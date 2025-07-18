package com.security.securityProject.exception;

public class MalformedJwtTokenException extends RuntimeException {
    public MalformedJwtTokenException(String message) {
        super(message);
    }
}
