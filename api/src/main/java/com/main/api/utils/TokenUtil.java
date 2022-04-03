package com.main.api.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class TokenUtil {
    public static final int TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24;

    public static final int REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;

    public static final String TOKEN_SECRET_KEY = "038sadac144a-0dasdas626-4fhudasUc9c-a0hfjdlkshfoiu487f-78d1f650ccfa";

    public static final String REFRESH_TOKEN_SECRET_KEY = "78ddasUcsaa-0sf650cs626-4fhuddac144c9c-a0hfjdhfakoiu487f-dasdl1038ucfa";

    // 禁止实例化
    private TokenUtil() {
    }

    ;

    public static TokenState verifyToken(String token) {
        return getTokenState(token, TOKEN_SECRET_KEY);
    }

    public static TokenState verifyRefreshToken(String token) {
        return getTokenState(token, REFRESH_TOKEN_SECRET_KEY);
    }

    private static TokenState getTokenState(String token, String tokenSecretKey) {
        try {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(tokenSecretKey)).build();
            jwtVerifier.verify(token);
            return TokenState.LEGAL;
        } catch (SignatureVerificationException | JWTDecodeException e) {
            log.warn(e.getMessage());
            return TokenState.ILLEGAL;
        } catch (TokenExpiredException e) {
            log.warn(e.getMessage());
            return TokenState.EXPIRED;
        } catch (Exception e) {
            log.warn(e.getMessage());
            return TokenState.ERROR;
        }
    }

    public static String createToken(Long userId, String userName, Byte role) {
        Date expireDate = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME);
        // 设置Token
        return JWT.create()
                .withAudience(String.valueOf(userId))
                .withClaim("userId", String.valueOf(userId))
                .withClaim("userName", userName)
                .withClaim("role", String.valueOf(role))
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(TOKEN_SECRET_KEY));
    }

    public static String createRefreshToken(Long userId, String userName, Byte role) {
        Date expireDate = new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRE_TIME);
        // 设置refreshToken
        return JWT.create()
                .withAudience(String.valueOf(userId))
                .withClaim("userId", String.valueOf(userId))
                .withClaim("userName", userName)
                .withClaim("role", String.valueOf(role))
                .withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(REFRESH_TOKEN_SECRET_KEY));
    }

    public static String getUserName(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String userName = jwt.getClaim("userName").toString();
        userName = userName.substring(1, userName.length() - 1);
        return userName;
    }

    public static Long getUserId(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String userId = jwt.getClaim("userId").toString();
        userId = userId.substring(1, userId.length() - 1);
        return Long.valueOf(userId);
    }

    public static Byte getUserRole(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String userId = jwt.getClaim("role").toString();
        userId = userId.substring(1, userId.length() - 1);
        return Byte.valueOf(userId);
    }
}
