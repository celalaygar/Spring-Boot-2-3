package com.tracker.job_ts.auth.service;


import com.tracker.job_ts.auth.config.JWTProvider;
import com.tracker.job_ts.auth.dto.RegisterRequest;
import com.tracker.job_ts.auth.entity.User;
import com.tracker.job_ts.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AuthHelperService {

    private final UserRepository userRepository;

    public Mono<User> getAuthUser() {
        return ReactiveSecurityContextHolder.getContext()
                .map(securityContext -> {
                    String email = securityContext.getAuthentication().getName();
                    return userRepository.findByEmail(email); // Bu, Mono<User> döndürüyor
                })
                .flatMap(userMono -> userMono); // Mono<User> döndürüyor
    }
}
