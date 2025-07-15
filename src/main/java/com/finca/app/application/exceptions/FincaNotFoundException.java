package com.finca.app.application.exceptions;

public class FincaNotFoundException extends RuntimeException  {
    public FincaNotFoundException(String message) {
        super(message);
    }
}
