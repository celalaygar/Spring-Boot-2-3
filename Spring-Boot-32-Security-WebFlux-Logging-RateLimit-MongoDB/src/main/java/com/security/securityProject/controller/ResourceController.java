package com.security.securityProject.controller;



import com.security.securityProject.dto.AuthRequest;
import com.security.securityProject.entity.User;
import com.security.securityProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResourceController {

    private final UserRepository userRepository;

    @GetMapping("/public")
    public Mono<String> publicEndpoint() {
        return Mono.just("Bu herkese açık bir endpoint.");
    }

    @PostMapping("/user")
    public Mono<String> userEndpoint(@RequestBody AuthRequest authentication) {
        return getAuthUser()
                .flatMap(authUser ->
                        Mono.just( "Merhaba " + authUser.getEmail() + "! Bu sadece kullanıcılara özel bir endpoint.")
                );
    }

    @PostMapping("/admin")
    public Mono<String> adminEndpoint(@RequestBody AuthRequest authentication) {
        return Mono.just( "Merhaba Admin " + authentication.getEmail() + "! Bu sadece yöneticilere özel bir endpoint.");
    }

    public Mono<User> getAuthUser() {
        return ReactiveSecurityContextHolder.getContext()
                .map(securityContext -> {
                    String email = securityContext.getAuthentication().getName();
                    return userRepository.findByEmail(email); // Bu, Mono<User> döndürüyor
                })
                .flatMap(userMono -> userMono); // Mono<User> döndürüyor
    }
}