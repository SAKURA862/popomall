package com.main.api.exception;

public class AccessDeniedException extends RuntimeException {
    String message = "权限不足";

    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
