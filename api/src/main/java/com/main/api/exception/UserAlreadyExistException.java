package com.main.api.exception;

public class UserAlreadyExistException extends RuntimeException {

    String message = "用户已存在";

    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
