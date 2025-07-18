package com.security.securityProject.filter;

import com.security.securityProject.config.JwtUtil; // JwtUtil'in doğru paketten geldiğinden emin olun
import com.security.securityProject.entity.ApiLog;
import com.security.securityProject.entity.User; // Eğer User nesnesi kullanılıyorsa
import com.security.securityProject.repository.UserRepository; // Eğer UserRepository kullanılıyorsa
import com.security.securityProject.service.LoggingService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.security.core.context.ReactiveSecurityContextHolder; // Eğer güvenlik bağlamından kullanıcı alınıyorsa
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class RequestResponseLoggingFilter implements WebFilter {

    private static final String TRACE_ID_HEADER = "X-Trace-ID"; // Trace ID için özel header adı

    private final LoggingService loggingService;
    private final JwtUtil jwtUtil;
    // private final UserRepository userRepository; // Eğer getAuthUser() kullanılıyorsa aktif edin

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();
        String requestId = UUID.randomUUID().toString();
        String traceId = UUID.randomUUID().toString(); // Yeni: Trace ID oluştur

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        DataBufferFactory bufferFactory = response.bufferFactory();

        // Yanıt header'ına Trace ID ekle
        response.getHeaders().add(TRACE_ID_HEADER, traceId);

        ApiLog apiLog = new ApiLog();
        apiLog.setRequestId(requestId);
        apiLog.setTraceId(traceId); // ApiLog'a Trace ID'yi set et
        apiLog.setRequestTime(LocalDateTime.now()); // İstek zamanını set et
        apiLog.setMethod(request.getMethod().name());
        apiLog.setPath(request.getPath().value());
        apiLog.setClientIp(request.getRemoteAddress() != null ? request.getRemoteAddress().getHostString() : "unknown");
        apiLog.setRequestHeaders(request.getHeaders().toSingleValueMap());

        // Token ve Email bilgilerini al (eğer varsa)
        String authorizationHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            apiLog.setToken(token); // Token'ı kaydet
            try {
                // Token geçerliyse email'i al
                if (jwtUtil.validateToken(token)) {
                    String email = jwtUtil.getUsernameFromToken(token);
                    apiLog.setEmail(email); // Email'i kaydet
                    apiLog.setAuthenticatedUser(email); // AuthenticatedUser olarak email'i kullan
                } else {
                    apiLog.setAuthenticatedUser("invalid_token");
                }
            } catch (Exception e) {
                // Token parse edilirken hata oluşursa
                apiLog.setAuthenticatedUser("token_error");
                System.err.println("Token işlenirken hata: " + e.getMessage());
            }
        } else {
            apiLog.setAuthenticatedUser("anonymous"); // Token yoksa anonim
        }

        // İstek gövdesini yakala ve yeniden hazırla
        return DataBufferUtils.join(request.getBody())
                .defaultIfEmpty(bufferFactory.wrap(new byte[0])) // İstek gövdesi yoksa boş DataBuffer sağla
                .flatMap(requestDataBuffer -> {
                    // İstek gövdesini kopyala ve byte[]'e oku
                    DataBuffer retainedRequestDataBuffer = DataBufferUtils.retain(requestDataBuffer);
                    byte[] requestBodyBytes = new byte[retainedRequestDataBuffer.readableByteCount()];
                    retainedRequestDataBuffer.read(requestBodyBytes);
                    DataBufferUtils.release(retainedRequestDataBuffer); // Okuma bittikten sonra serbest bırak

                    String requestBody = new String(requestBodyBytes, StandardCharsets.UTF_8);
                    apiLog.setRequestBody(requestBody);
                    System.out.println("Request Body Yakalandı (Filter): " + requestBody); // Debug log

                    // İstek gövdesini yeniden akışa veren bir ServerHttpRequestDecorator oluşturulur.
                    ServerHttpRequest decoratedRequest = new ServerHttpRequestDecorator(request) {
                        @Override
                        public Flux<DataBuffer> getBody() {
                            return Flux.just(bufferFactory.wrap(requestBodyBytes));
                        }
                    };

                    // Yanıt gövdesini yakalayacak bir ServerHttpResponseDecorator oluşturulur.
                    // Yanıt gövdesini yakalamak için Mono.defer kullanmak, akışın doğru zamanda tetiklenmesini sağlar.
                    ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(response) {
                        @Override
                        public Mono<Void> writeWith(org.reactivestreams.Publisher<? extends DataBuffer> body) {
                            // Yanıt gövdesi boş olabileceği için defaultIfEmpty ile boş bir DataBuffer sağlarız.
                            return DataBufferUtils.join(Flux.from(body))
                                    .defaultIfEmpty(bufferFactory.wrap(new byte[0]))
                                    .flatMap(responseDataBuffer -> {
                                        DataBuffer retainedResponseDataBuffer = DataBufferUtils.retain(responseDataBuffer);
                                        byte[] responseBodyBytes = new byte[retainedResponseDataBuffer.readableByteCount()];
                                        retainedResponseDataBuffer.read(responseBodyBytes);
                                        DataBufferUtils.release(retainedResponseDataBuffer);

                                        String responseBody = new String(responseBodyBytes, StandardCharsets.UTF_8);
                                        apiLog.setResponseBody(responseBody);
                                        System.out.println("Response Body Yakalandı (Filter): " + responseBody); // Debug log

                                        // Orijinal yanıt akışını devam ettir.
                                        return super.writeWith(Mono.just(bufferFactory.wrap(responseBodyBytes)));
                                    });
                        }
                    };

                    // Filtre zincirini devam ettir ve tamamlandığında loglama işlemini yap.
                    return chain.filter(exchange.mutate().request(decoratedRequest).response(decoratedResponse).build())
                            .doFinally(signalType -> {
                                // İstek tamamlandığında loglama işlemini bitir
                                apiLog.setResponseTime(LocalDateTime.now());
                                apiLog.setStatusCode(response.getStatusCode() != null ? response.getStatusCode().value() : 0);
                                apiLog.setResponseHeaders(response.getHeaders().toSingleValueMap());
                                apiLog.setDurationMillis(System.currentTimeMillis() - startTime);
                                loggingService.saveApiLog(apiLog).subscribe();

                                DataBufferUtils.release(requestDataBuffer); // Orijinal istek DataBuffer'ını serbest bırak
                            });
                })
                .onErrorResume(e -> {
                    System.err.println("RequestResponseLoggingFilter sırasında hata oluştu: " + e.getMessage());
                    apiLog.setResponseTime(LocalDateTime.now());
                    apiLog.setAuthenticatedUser(apiLog.getAuthenticatedUser() != null ? apiLog.getAuthenticatedUser() : "anonymous"); // Hata anında da kullanıcı bilgisini koru
                    apiLog.setResponseBody("Filtre işleme sırasında hata oluştu: " + e.getMessage());
                    apiLog.setStatusCode(response.getStatusCode() != null ? response.getStatusCode().value() : 500);
                    apiLog.setDurationMillis(System.currentTimeMillis() - startTime);
                    loggingService.saveApiLog(apiLog).subscribe();
                    return Mono.error(e);
                });
    }

    // Bu metod filtre içinde doğrudan kullanılmıyor, ancak örneğinizde olduğu için bırakıldı.
    // Eğer güvenlik bağlamından kullanıcı alacaksanız, bu metodu kullanabilirsiniz.
    /*
    public Mono<User> getAuthUser() {
        return ReactiveSecurityContextHolder.getContext()
                .map(securityContext -> {
                    String email = securityContext.getAuthentication().getName();
                    return userRepository.findByEmail(email); // Bu, Mono<User> döndürüyor
                })
                .flatMap(userMono -> userMono); // Mono<User> döndürüyor
    }
    */
}
