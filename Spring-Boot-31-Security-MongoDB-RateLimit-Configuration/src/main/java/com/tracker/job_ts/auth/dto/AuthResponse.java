package com.tracker.job_ts.auth.dto;


import com.tracker.job_ts.auth.entity.User;
import lombok.Builder;
import lombok.Data;


@Data
public class AuthResponse {
    private UserDto user;
    private String token;

    public AuthResponse() {
    }

    public AuthResponse(User user, String token) {
        this.user = new UserDto(user);
        this.token = token;
    }
}