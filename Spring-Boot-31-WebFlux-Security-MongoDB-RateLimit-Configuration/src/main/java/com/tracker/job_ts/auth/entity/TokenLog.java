package com.tracker.job_ts.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("token_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenLog {
    @Id
    private String id;
    private String email;
    private String username;
    private String token;
    private Instant createdAt;
}
