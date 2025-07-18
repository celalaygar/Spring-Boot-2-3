package com.security.securityProject.service;

import com.security.securityProject.entity.ApiLog;
import com.security.securityProject.repository.ApiLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LoggingService {

    private final ApiLogRepository apiLogRepository;

    public Mono<ApiLog> saveApiLog(ApiLog apiLog) {
        return apiLogRepository.save(apiLog)
                .doOnSuccess(savedLog -> System.out.println("API Log kaydedildi: " + savedLog.getTraceId()))
                .doOnError(e -> System.err.println("API Log kaydederken hata oluştu: " + e.getMessage()));
    }
}