package com.tracker.job_ts.auth.dto;

import com.tracker.job_ts.auth.entity.SystemRole;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequest {
    private String email;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private Set<SystemRole> systemRoles; // örneğin: ["USER"] veya ["ADMIN"]
}