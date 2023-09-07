package com.rocket.rocket_project.exception;

import lombok.Getter;

@Getter
public class ForbiddenException extends RuntimeException{
    private final String message;
    public ForbiddenException(String message) {
        super(message);
        this.message = message;
    }
}
