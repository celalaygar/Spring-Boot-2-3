package com.security.securityProject.repository;

import com.security.securityProject.entity.ApiLog;
import com.security.securityProject.entity.RateLimitConfig;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RateLimitConfigRepository extends ReactiveMongoRepository<RateLimitConfig, String> {
    Mono<RateLimitConfig> findByEndpoint(String endpoint);
}