package com.main.api.exception;

public class DeleteFailException extends RuntimeException {

    String message = "删除失败";

    public DeleteFailException() {
        super();
    }

    public DeleteFailException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
