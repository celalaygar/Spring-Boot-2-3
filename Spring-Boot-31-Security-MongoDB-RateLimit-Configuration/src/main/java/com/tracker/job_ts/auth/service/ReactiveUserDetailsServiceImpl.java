package com.tracker.job_ts.auth.service;



import com.tracker.job_ts.auth.entity.User;
import com.tracker.job_ts.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReactiveUserDetailsServiceImpl  {

    private final UserRepository userRepository;

    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(this::mapToUserDetails);
    }

    private UserDetails mapToUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getSystemRoles().stream()
                        .map(role -> role.name().replace("ROLE_", "")) // Spring Security expects role names without "ROLE_" prefix
                        .toArray(String[]::new))
                .build();
    }
}
