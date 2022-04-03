package com.main.api.utils;

/**
 * @author roxy
 */

public enum TokenState {
    /**
     * EXPIRED token过期状态
     * ILLEGAL token解码失败状态
     * LEGAL token正常状态
     * ERROR 解码token发生其他异常状态
     */
    EXPIRED,
    ILLEGAL,
    LEGAL,
    ERROR
}
