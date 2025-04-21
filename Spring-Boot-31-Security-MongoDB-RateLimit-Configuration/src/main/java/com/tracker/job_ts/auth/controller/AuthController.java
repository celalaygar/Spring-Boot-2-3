package com.tracker.job_ts.auth.controller;

import com.tracker.job_ts.auth.dto.AuthRequest;
import com.tracker.job_ts.auth.dto.AuthResponse;
import com.tracker.job_ts.auth.dto.RegisterRequest;
import com.tracker.job_ts.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public Mono<ResponseEntity<Object>> register(@RequestBody RegisterRequest request) {
        return authService.register(request)
                .map(msg -> ResponseEntity.ok(msg));
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest request) {
        return authService.login(request)
                .map(ResponseEntity::ok);
    }
}
