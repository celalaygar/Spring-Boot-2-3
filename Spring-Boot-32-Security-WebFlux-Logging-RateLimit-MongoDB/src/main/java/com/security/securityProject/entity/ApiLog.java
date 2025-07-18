package com.security.securityProject.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@Document(collection = "api_logs")
public class ApiLog {
    @Id
    private String id;
    private String traceId;
    private String requestId; // İstek benzersiz ID'si
    private LocalDateTime requestTime;
    private String token;
    private String email;
    private String method;
    private String path;
    private Map<String, String> requestHeaders;
    private String requestBody;
    private String clientIp;
    private String authenticatedUser; // İstek atan kullanıcı (email veya ID)
    private int statusCode;
    private LocalDateTime responseTime;
    private Map<String, String> responseHeaders;
    private String responseBody;
    private long durationMillis;
}