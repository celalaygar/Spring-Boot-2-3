package com.tracker.job_ts.siber.config;

import com.tracker.job_ts.siber.dto.RateLimitClientDto;
import com.tracker.job_ts.siber.entity.RateLimit;
import com.tracker.job_ts.siber.repository.RateLimitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

@Component
public class RateLimiterFilter implements WebFilter {

    private final RateLimitRepository rateLimitRepository;

    private static final int DEFAULT_MAX_REQUESTS = 5;
    private static final int AUTH_MAX_REQUESTS = 2;
    private static final Duration WINDOW = Duration.ofSeconds(60);

    // Hedeflenen path'ler
    private static final Set<String> AUTH_ENDPOINTS = Set.of(
            "/api/auth/login",
            "/api/auth/register"
    );

    public RateLimiterFilter(RateLimitRepository rateLimitRepository) {
        this.rateLimitRepository = rateLimitRepository;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().value();
        RateLimitClientDto dto = getClientId(exchange);
        dto.setPath(path);

        int maxRequests = AUTH_ENDPOINTS.contains(path) ? AUTH_MAX_REQUESTS : DEFAULT_MAX_REQUESTS;

        return rateLimitRepository.findById(dto.getCliendId() + ":" + path)
                .defaultIfEmpty(new RateLimit())
                .flatMap(rateLimit -> {
                    Instant now = Instant.now();

                    if (rateLimit.getId() == null) {
                        rateLimit.setId(dto.getCliendId() + ":" + path);
                        rateLimit.setToken(dto.getToken());
                        rateLimit.setLastRequestTime(now);
                        rateLimit.setRequestCount(1);
                        rateLimit.setPath(path);
                    } else {
                        Duration elapsed = Duration.between(rateLimit.getLastRequestTime(), now);
                        if (elapsed.compareTo(WINDOW) > 0) {
                            rateLimit.setLastRequestTime(now);
                            rateLimit.setRequestCount(1);
                        } else if (rateLimit.getRequestCount() < maxRequests) {
                            rateLimit.setRequestCount(rateLimit.getRequestCount() + 1);
                        } else {
                            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                            return exchange.getResponse().setComplete();
                        }
                    }

                    return rateLimitRepository.save(rateLimit).then(chain.filter(exchange));
                });
    }

    private RateLimitClientDto getClientId(ServerWebExchange exchange) {
        // JWT varsa kullanıcının ID'si, yoksa IP adresi
        RateLimitClientDto dto = new RateLimitClientDto();
        String ip = exchange.getRequest().getHeaders().getFirst("X-Forwarded-For");
        if (ip == null) {
            ip = exchange.getRequest().getRemoteAddress() != null ?
                    exchange.getRequest().getRemoteAddress().getAddress().getHostAddress() : "unknown";
        }
        dto.setCliendId(ip);
        dto.setToken(exchange.getRequest().getHeaders().getFirst("Authorization"));
        return dto;
    }
}
