package com.tracker.job_ts.siber.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateLimitDto {
    private String id; // userId veya IP
    private int requestCount;
    private Instant lastRequestTime;
    private String token;
}
