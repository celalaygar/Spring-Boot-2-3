package com.security.securityProject.controller;


import com.security.securityProject.dto.AuthRequest;
import com.security.securityProject.dto.AuthResponse;
import com.security.securityProject.dto.RegisterRequest;
import com.security.securityProject.entity.Role;
import com.security.securityProject.entity.User;
import com.security.securityProject.repository.RoleRepository;
import com.security.securityProject.repository.UserRepository;
import com.security.securityProject.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ReactiveUserDetailsService userDetailsService;

    @PostMapping("/register")
    public Mono<ResponseEntity<String>> register(@RequestBody RegisterRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .flatMap(existingUser -> Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists")))
                .switchIfEmpty(Mono.defer(() ->
                        roleRepository.findByName("ROLE_USER") // Varsayılan rol: USER
                                .switchIfEmpty(Mono.error(new RuntimeException("ROLE_USER not found in database")))
                                .flatMap(userRole -> {
                                    User newUser = new User();
                                    newUser.setEmail(request.getEmail());
                                    newUser.setPassword(passwordEncoder.encode(request.getPassword()));
                                    Set<String> roles = new HashSet<>();
                                    roles.add(userRole.getName());
                                    newUser.setRoles(roles);
                                    return userRepository.save(newUser)
                                            .map(savedUser -> ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully"));
                                })
                ));
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest request) {
        return userDetailsService.findByUsername(request.getEmail())
                .filter(userDetails -> passwordEncoder.matches(request.getPassword(), userDetails.getPassword()))
                .map(userDetails -> {
                    String token = jwtUtil.generateToken((org.springframework.security.core.userdetails.User) userDetails);
                    return ResponseEntity.ok(new AuthResponse(token));
                })
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}