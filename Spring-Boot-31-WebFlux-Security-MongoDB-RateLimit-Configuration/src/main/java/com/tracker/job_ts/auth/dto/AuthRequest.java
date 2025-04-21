package com.tracker.job_ts.auth.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String username;
    private String password;
}
