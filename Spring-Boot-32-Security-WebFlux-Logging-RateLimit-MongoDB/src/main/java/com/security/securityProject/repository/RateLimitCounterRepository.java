package com.security.securityProject.repository;

import com.security.securityProject.entity.RateLimitConfig;
import com.security.securityProject.entity.RateLimitCounter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RateLimitCounterRepository extends ReactiveMongoRepository<RateLimitCounter, String> {
    Mono<RateLimitCounter> findByEndpointAndIdentifier(String endpoint, String identifier);
}