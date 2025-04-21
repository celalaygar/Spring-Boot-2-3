package com.tracker.job_ts.auth.controller;


import com.tracker.job_ts.auth.entity.SystemRole;
import com.tracker.job_ts.auth.entity.User;
import com.tracker.job_ts.auth.repository.UserRepository;
import com.tracker.job_ts.auth.service.AuthHelperService;
import com.tracker.job_ts.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final AuthHelperService authHelperService;

    @GetMapping("/profile")
    public Mono<User> getUserProfile() {
        return authHelperService.getAuthUser();
    }

    @GetMapping("/admin")
    public Mono<String> getAdminPage() {
        return Mono.just("Welcome ROLE_ADMIN");
    }

    @GetMapping("/deleted")
    public Mono<String> getDeletedPage() {
        return Mono.just("Welcome ROLE_DELETED");
    }

    @GetMapping("/passive")
    public Mono<String> getPassivePage() {
        return Mono.just("Welcome ROLE_PASSIVE");
    }
}
