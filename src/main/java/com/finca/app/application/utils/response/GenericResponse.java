package com.finca.app.application.utils.response;

import java.time.LocalDateTime;

public class GenericResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public GenericResponse(int status, String message, LocalDateTime timestamp){
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
