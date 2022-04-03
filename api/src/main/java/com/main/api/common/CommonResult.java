package com.main.api.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
    private ResultCode resultCode;
    private String msg;
    private Object data;

    public CommonResult() {
    }

    public CommonResult(ResultCode resultCode, String msg) {
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public CommonResult(ResultCode resultCode, String msg, Object data) {
        this.resultCode = resultCode;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResult success(Object data) {
        return new CommonResult(ResultCode.SUCCESS, ResultCode.SUCCESS.getMessage(), data);
    }

    public static CommonResult success(Object data, String message) {
        return new CommonResult(ResultCode.SUCCESS, message, data);
    }

    public static CommonResult failed(Object data) {
        return new CommonResult(ResultCode.FAIL, ResultCode.FAIL.getMessage(), data);
    }

    public static CommonResult failed(Object data, String message) {
        return new CommonResult(ResultCode.FAIL, message, data);
    }

    public static CommonResult validationFails(Object data) {
        return new CommonResult(ResultCode.VALIDATION_FAILS, ResultCode.VALIDATION_FAILS.getMessage(), data);
    }

    public static CommonResult validationFails(Object data, String message) {
        return new CommonResult(ResultCode.VALIDATION_FAILS, message, data);
    }

    public static CommonResult signupSuccess(Object data) {
        return new CommonResult(ResultCode.SIGNUP_SUCCESS, ResultCode.SIGNUP_SUCCESS.getMessage(), data);
    }

    public static CommonResult signupSuccess(Object data, String message) {
        return new CommonResult(ResultCode.SIGNUP_SUCCESS, message, data);
    }

    public static CommonResult noneResult(Object data) {
        return new CommonResult(ResultCode.NONE_RESULT, ResultCode.NONE_RESULT.getMessage(), data);
    }

    public static CommonResult noneResult(Object data, String message) {
        return new CommonResult(ResultCode.NONE_RESULT, message, data);
    }

    public static CommonResult reRequest(Object data) {
        return new CommonResult(ResultCode.RE_REQUEST, ResultCode.RE_REQUEST.getMessage(), data);
    }

    public static CommonResult reRequest(Object data, String message) {
        return new CommonResult(ResultCode.RE_REQUEST, message, data);
    }
}
