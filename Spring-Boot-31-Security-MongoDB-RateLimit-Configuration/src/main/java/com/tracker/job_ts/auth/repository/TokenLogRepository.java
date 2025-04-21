package com.tracker.job_ts.auth.repository;


import com.tracker.job_ts.auth.entity.TokenLog;
import com.tracker.job_ts.auth.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TokenLogRepository extends ReactiveMongoRepository<TokenLog, String> {
}
