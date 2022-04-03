package com.main.api.exception;

public class NoResultException extends RuntimeException {

    String message = "查询无结果";

    public NoResultException() {
        super();
    }

    public NoResultException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
