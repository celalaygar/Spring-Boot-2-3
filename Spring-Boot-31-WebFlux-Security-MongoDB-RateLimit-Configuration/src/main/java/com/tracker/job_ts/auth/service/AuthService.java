package com.tracker.job_ts.auth.service;


import com.tracker.job_ts.auth.config.JWTProvider;
import com.tracker.job_ts.auth.dto.AuthRequest;
import com.tracker.job_ts.auth.dto.AuthResponse;
import com.tracker.job_ts.auth.dto.RegisterRequest;
import com.tracker.job_ts.auth.entity.SystemRole;
import com.tracker.job_ts.auth.entity.User;
import com.tracker.job_ts.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;
    private final TokenLogService tokenLogService;

    public Mono<Object> register(RegisterRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .flatMap(existing -> Mono.error(new RuntimeException("Email already exists")))
                .switchIfEmpty(Mono.defer(() -> {
                    User user = User.builder()
                            .email(request.getEmail())
                            .username(request.getUsername())
                            .firstname(request.getFirstname())
                            .lastname(request.getLastname())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .systemRoles(request.getSystemRoles())
                            .build();
                    return userRepository.save(user)
                            .thenReturn("User registered successfully");
                }));
    }

    public Mono<AuthResponse> login(AuthRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .switchIfEmpty(Mono.error(new RuntimeException("User not found")))
                .flatMap(user -> {
                    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        return Mono.error(new RuntimeException("Invalid credentials"));
                    }

                    List<SystemRole> roles = user.getSystemRoles().stream().collect(Collectors.toList());
                    String token = jwtProvider.generateToken(user.getEmail(), roles);

                    return tokenLogService.logToken(user, token, Instant.now())
                            .thenReturn(new AuthResponse(user,token));
                });
    }
}
