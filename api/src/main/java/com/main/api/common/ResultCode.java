package com.main.api.common;

public enum ResultCode {
    /**
     * SUCCESS 操作成功时返回结果码
     * FAIL 操作失败时返回结果码
     * NONE_RESULT 数据库查询无结果时返回结果码
     * UNAUTHORIZED token验证失败时返回结果码
     * RE_REQUEST token已过期但是可以刷新时返回结果码
     * VALIDATION_FAILS token验证失败时返回结果码
     * SIGNUP_SUCCESS 注册账户成功时返回结果码
     */
    SUCCESS(200, "操作成功"),
    FAIL(500, "操作失败"),
    NONE_RESULT(404, "查询失败"),
    UNAUTHORIZED(401, "需要身份验证"),
    RE_REQUEST(205, "需重新请求"),
    VALIDATION_FAILS(402, "token验证失败"),
    SIGNUP_SUCCESS(200, "注册成功");

    private final int statusCode;
    private final String msg;

    ResultCode(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public int getCode() {
        return statusCode;
    }

    public String getMessage() {
        return msg;
    }
}
