package com.security.securityProject.filter;


import com.security.securityProject.entity.RateLimitConfig;
import com.security.securityProject.entity.RateLimitCounter;
import com.security.securityProject.repository.RateLimitConfigRepository;
import com.security.securityProject.repository.RateLimitCounterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class RateLimitingWebFilter implements WebFilter {

    private final RateLimitConfigRepository rateLimitConfigRepository;
    private final RateLimitCounterRepository rateLimitCounterRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().value();
        String identifier = exchange.getRequest().getRemoteAddress() != null ?
                exchange.getRequest().getRemoteAddress().getHostString() : "anonymous"; // IP adresi veya Auth'dan kullanıcı ID'si

        // İsteği atan kullanıcıyı al
        return exchange.getPrincipal()
                .map(principal -> principal.getName())
                .defaultIfEmpty(identifier) // Eğer kullanıcı yoksa IP adresini kullan
                .flatMap(userIdentifier ->
                        rateLimitConfigRepository.findByEndpoint(path)
                                .switchIfEmpty(Mono.defer(() -> {
                                    // Eğer endpoint için config yoksa, varsayılan bir limit uygula veya devam et
                                    // Burada devam etmeyi seçiyoruz, yani limit uygulanmaz
                                    return Mono.just(new RateLimitConfig()); // Boş config, limit yok anlamına gelir
                                }))
                                .flatMap(config -> {
                                    if (config.getLimit() == 0) { // Limit yoksa devam et
                                        return chain.filter(exchange);
                                    }

                                    String counterId = path + ":" + userIdentifier;
                                    return rateLimitCounterRepository.findById(counterId)
                                            .defaultIfEmpty(new RateLimitCounter())
                                            .flatMap(counter -> {
                                                LocalDateTime now = LocalDateTime.now();
                                                if (counter.getId() == null || counter.getLastResetTime().plusSeconds(config.getDurationSeconds()).isBefore(now)) {
                                                    // Yeni periyot veya ilk istek
                                                    counter.setId(counterId);
                                                    counter.setEndpoint(path);
                                                    counter.setIdentifier(userIdentifier);
                                                    counter.setCount(1);
                                                    counter.setLastResetTime(now);
                                                    return rateLimitCounterRepository.save(counter).then(chain.filter(exchange));
                                                } else if (counter.getCount() < config.getLimit()) {
                                                    // Limit aşılmamış
                                                    counter.setCount(counter.getCount() + 1);
                                                    return rateLimitCounterRepository.save(counter).then(chain.filter(exchange));
                                                } else {
                                                    // Limit aşıldı
                                                    exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                                                    return exchange.getResponse().setComplete();
                                                }
                                            });
                                })
                );
    }
}