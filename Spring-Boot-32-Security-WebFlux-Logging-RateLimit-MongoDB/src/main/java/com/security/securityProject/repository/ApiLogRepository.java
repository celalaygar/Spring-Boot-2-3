package com.security.securityProject.repository;

import com.security.securityProject.entity.ApiLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ApiLogRepository extends ReactiveMongoRepository<ApiLog, String> {
    // Özel sorgular gerekirse buraya eklenebilir
}