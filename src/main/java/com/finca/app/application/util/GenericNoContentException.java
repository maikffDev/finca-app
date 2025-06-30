package com.finca.app.application.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT) // 204
public class GenericNoContentException extends RuntimeException {
    public GenericNoContentException(String message) {
        super(message);
    }
}

