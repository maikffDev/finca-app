package com.finca.app.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT) // 204
public class GenericNoContentException2 extends RuntimeException {
    public GenericNoContentException2(String message) {
        super(message);
    }
}

