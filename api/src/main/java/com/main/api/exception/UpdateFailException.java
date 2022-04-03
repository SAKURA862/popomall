package com.main.api.exception;

public class UpdateFailException extends RuntimeException {

    String message = "更新失败";

    public UpdateFailException() {
        super();
    }

    public UpdateFailException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
