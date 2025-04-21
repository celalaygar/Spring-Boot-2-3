package com.tracker.job_ts.auth.controller;


import com.tracker.job_ts.auth.entity.User;
import com.tracker.job_ts.auth.repository.UserRepository;
import com.tracker.job_ts.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/deleted")
@RequiredArgsConstructor
public class DeletedController {

    // Admin'e özel endpoint
    @GetMapping("/get-message")
    public Mono<String> getDeletedPage() {
        return Mono.just("Welcome ROLE_DELETED");
    }

}
