package com.main.api.exception;

public class BadRequestException extends RuntimeException {

    String message = "参数异常";

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
