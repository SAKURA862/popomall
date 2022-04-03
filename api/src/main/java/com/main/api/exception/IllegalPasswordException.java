package com.main.api.exception;

public class IllegalPasswordException extends RuntimeException {

    String message = "密码异常";

    public IllegalPasswordException() {
        super();
    }

    public IllegalPasswordException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
