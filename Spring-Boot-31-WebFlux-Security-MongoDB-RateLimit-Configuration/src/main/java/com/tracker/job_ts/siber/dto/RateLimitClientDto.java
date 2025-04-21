package com.tracker.job_ts.siber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitClientDto {
    private String cliendId;
    private String token;
    private String path;

}
