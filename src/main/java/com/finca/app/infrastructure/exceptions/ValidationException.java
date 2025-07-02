package com.finca.app.infrastructure.exceptions;

public class DomainValidationException extends RuntimeException {
    public DomainValidationException(String message) {
        super(message);
    }
    public DomainValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
