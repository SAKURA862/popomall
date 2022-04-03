package com.main.api.exception;

public class InsertFailException extends RuntimeException {

    String message = "插入失败";

    public InsertFailException() {
        super();
    }

    public InsertFailException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
