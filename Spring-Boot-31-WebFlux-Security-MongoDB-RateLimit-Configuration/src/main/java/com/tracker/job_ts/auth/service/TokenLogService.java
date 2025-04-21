package com.tracker.job_ts.auth.service;

import com.tracker.job_ts.auth.entity.TokenLog;
import com.tracker.job_ts.auth.entity.User;
import com.tracker.job_ts.auth.repository.TokenLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TokenLogService {


    private final TokenLogRepository tokenLogRepository;

    public Mono<TokenLog> logToken(User user, String token, Instant createdAt) {
        TokenLog tokenLog = TokenLog.builder()
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(createdAt)
                .build();
        return tokenLogRepository.save(tokenLog);
    }
}
