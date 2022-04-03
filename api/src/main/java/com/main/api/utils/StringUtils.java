package com.main.api.utils;

import sun.misc.BASE64Encoder;

public class StringUtils {
    public static boolean isBlank(String s) {
        return (s == null || s.trim().length() == 0);
    }

    // 禁止实例化
    private StringUtils() {
    }

    public static boolean isNotBlank(String s) {
        return !isBlank(s);
    }


    public static boolean isValidPassword(String s) {
        boolean hasIllegalCharacter = s.matches(".*[^0-9a-zA-Z~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"].*");
        return (!hasIllegalCharacter);
    }

    public static boolean isValidPassword(String s, String userName) {
        boolean hasIllegalCharacter = s.matches(".*[^0-9a-zA-Z~!@#$%^&*()_+|<>,.?/:;'\\[\\]{}\"].*");
        int len = s.length();
        boolean includeUserName = s.contains(userName);
        return (!hasIllegalCharacter && (len >= 6 && len <= 18) && !includeUserName);
    }

    public static String byteArrayToStringBase64(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        //转换成base64串
        String png_base64 = encoder.encodeBuffer(bytes);
        //删除 \r\n
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");
        return png_base64;
    }
}
