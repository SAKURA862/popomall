package com.main.api.exception;

public class InsufficientPermissionException extends RuntimeException {
    String message = "权限不足";

    public InsufficientPermissionException() {
        super();
    }

    public InsufficientPermissionException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
