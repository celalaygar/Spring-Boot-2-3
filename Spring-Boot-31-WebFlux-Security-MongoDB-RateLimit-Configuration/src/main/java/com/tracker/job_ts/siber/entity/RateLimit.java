package com.tracker.job_ts.siber.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "rate_limits")
public class RateLimit {
    @Id
    private String id; // userId veya IP
    private int requestCount;
    private Instant lastRequestTime;
    private String token;
    private String path;
}
