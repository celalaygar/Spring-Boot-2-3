package com.security.securityProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rate_limit_configs")
public class RateLimitConfig {
    @Id
    private String id;
    private String endpoint; // Örneğin: /api/public, /api/admin
    private int limit; // Belirli zaman aralığında izin verilen istek sayısı
    private long durationSeconds; // Zaman aralığı (saniye)
}