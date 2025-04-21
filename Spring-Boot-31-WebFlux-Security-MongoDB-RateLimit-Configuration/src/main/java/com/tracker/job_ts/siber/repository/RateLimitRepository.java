package com.tracker.job_ts.siber.repository;


import com.tracker.job_ts.siber.entity.RateLimit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RateLimitRepository extends ReactiveMongoRepository<RateLimit, String> {
}