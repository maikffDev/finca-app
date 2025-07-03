package com.finca.app.application.services.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
public class GenericErrorException extends RuntimeException {
    public GenericErrorException(String message) {
        super(message);
    }
}
