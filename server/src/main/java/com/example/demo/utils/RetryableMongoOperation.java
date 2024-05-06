package com.example.demo.utils;

import com.mongodb.MongoException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Retryable(maxAttemptsExpression = "${spring.retry.max-attempts}",
        backoff = @Backoff(delayExpression = "${spring.retry.backoff.delay}"),
        retryFor = { MongoException.class })
public @interface RetryableMongoOperation {
}