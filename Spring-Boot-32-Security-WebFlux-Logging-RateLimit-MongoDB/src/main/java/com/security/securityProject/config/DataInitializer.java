package com.security.securityProject.config;


import com.security.securityProject.entity.RateLimitConfig;
import com.security.securityProject.entity.Role;
import com.security.securityProject.entity.User;
import com.security.securityProject.repository.RateLimitConfigRepository;
import com.security.securityProject.repository.RoleRepository;
import com.security.securityProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RateLimitConfigRepository rateLimitConfigRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            Mono<Role> userRoleMono = roleRepository.findByName("ROLE_USER")
                    .switchIfEmpty(roleRepository.save(new Role(null, "ROLE_USER")));
            Mono<Role> adminRoleMono = roleRepository.findByName("ROLE_ADMIN")
                    .switchIfEmpty(roleRepository.save(new Role(null, "ROLE_ADMIN")));

            Mono.zip(userRoleMono, adminRoleMono)
                    .flatMap(tuple -> {
                        Role userRole = tuple.getT1();
                        Role adminRole = tuple.getT2();

                        // Admin User
                        return userRepository.findByEmail("admin@example.com")
                                .switchIfEmpty(Mono.defer(() -> {
                                    User adminUser = new User();
                                    adminUser.setEmail("admin@example.com");
                                    adminUser.setPassword(passwordEncoder.encode("adminpass"));
                                    Set<String> adminRoles = new HashSet<>();
                                    adminRoles.add(adminRole.getName());
                                    adminRoles.add(userRole.getName());
                                    adminUser.setRoles(adminRoles);
                                    return userRepository.save(adminUser);
                                }))
                                .then(userRepository.findByEmail("user@example.com")
                                        .switchIfEmpty(Mono.defer(() -> {
                                            User normalUser = new User();
                                            normalUser.setEmail("user@example.com");
                                            normalUser.setPassword(passwordEncoder.encode("userpass"));
                                            Set<String> userRoles = new HashSet<>();
                                            userRoles.add(userRole.getName());
                                            normalUser.setRoles(userRoles);
                                            return userRepository.save(normalUser);
                                        })))
                                .then(Mono.defer(() -> {
                                    // Rate Limit Config for /api/public
                                    return rateLimitConfigRepository.findByEndpoint("/api/public")
                                            .switchIfEmpty(Mono.defer(() -> {
                                                RateLimitConfig publicApiLimit = new RateLimitConfig();
                                                publicApiLimit.setEndpoint("/api/public");
                                                publicApiLimit.setLimit(5); // 5 requests per 60 seconds
                                                publicApiLimit.setDurationSeconds(60);
                                                return rateLimitConfigRepository.save(publicApiLimit);
                                            }))
                                            .then(Mono.defer(() -> {
                                                // Rate Limit Config for /api/user
                                                return rateLimitConfigRepository.findByEndpoint("/api/user")
                                                        .switchIfEmpty(Mono.defer(() -> {
                                                            RateLimitConfig userApiLimit = new RateLimitConfig();
                                                            userApiLimit.setEndpoint("/api/user");
                                                            userApiLimit.setLimit(10); // 10 requests per 60 seconds
                                                            userApiLimit.setDurationSeconds(60);
                                                            return rateLimitConfigRepository.save(userApiLimit);
                                                        }));
                                            }));
                                }));
                    })
                    .subscribe(
                            null, // onNext
                            Throwable::printStackTrace, // onError
                            () -> System.out.println("Initial data (roles, users, rate limits) created successfully!") // onComplete
                    );
        };
    }
}