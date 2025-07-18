package com.security.securityProject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "rate_limit_counters")
public class RateLimitCounter {
    @Id
    private String id; // Örneğin: endpoint + ip_address veya endpoint + user_id
    private String endpoint;
    private String identifier; // IP adresi veya kullanıcı ID'si
    private long count;
    private LocalDateTime lastResetTime;
}
