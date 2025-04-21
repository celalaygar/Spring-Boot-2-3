package com.tracker.job_ts.auth.config;

import com.tracker.job_ts.auth.exception.UnauthorizedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JWTFilter implements WebFilter {

    private final JWTProvider jwtProvider;

    public JWTFilter(JWTProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String token = getJwtFromRequest(exchange);

        if (token != null && !"".equals(token) &&jwtProvider.validateToken(token)) {
            try {
                String username = jwtProvider.getUsernameFromToken(token);
                var authentication = new UsernamePasswordAuthenticationToken(
                        username, null, jwtProvider.getAuthorities(token));

                return chain.filter(exchange)
                        .contextWrite(ReactiveSecurityContextHolder.withAuthentication(authentication));
            } catch (Exception ex) {
                return Mono.error(new UnauthorizedException("JWT token authentication failed."));
            }
        }

        return chain.filter(exchange);
    }

    private String getJwtFromRequest(ServerWebExchange exchange) {
        return exchange.getRequest().getHeaders().getFirst("Authorization");
    }
}

