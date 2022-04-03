package com.main.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.main.api.common.CommonResult;
import com.main.api.common.ResultCode;
import com.main.api.utils.TokenState;
import com.main.api.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class TokenFilter implements GatewayFilter {

    /*@Autowired
    private RedisTemplate<Object, Object> redisTemplate;*/

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        redisTemplate = (RedisTemplate<Object, Object>) exchange.getApplicationContext().getBean("redisTemplate");

        ServerHttpResponse response = exchange.getResponse();

        String token = exchange.getRequest().getHeaders().getFirst("authrize");

        TokenState tokenState = TokenUtil.verifyToken(token);

        if (tokenState == TokenState.ERROR) {
            return getVoidMono(response, new CommonResult(ResultCode.FAIL, "发生异常，请重新登录", null));
        }
        if (tokenState == TokenState.ILLEGAL) {
            return getVoidMono(response, new CommonResult(ResultCode.FAIL, "无效Token，重新登录", null));
        } else if (tokenState == TokenState.EXPIRED) {
            // TODO refresh token
            String refreshToken = exchange.getRequest().getHeaders().getFirst("refreshAuthrize");
            TokenState refreshTokenState = TokenUtil.verifyRefreshToken(refreshToken);
            if (refreshTokenState != TokenState.LEGAL) {
                return getVoidMono(response, new CommonResult(ResultCode.FAIL, "登录已过期，重新登录", null));
            }
            Long userId = TokenUtil.getUserId(token);
            String userName = TokenUtil.getUserName(token);
            Byte userRole = TokenUtil.getUserRole(token);
            String newToken = TokenUtil.createToken(userId, userName, userRole);
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("authrize", newToken);
            tokenMap.put("refreshAuthrize", refreshToken);
            return getVoidMono(response, new CommonResult(ResultCode.RE_REQUEST, "token已刷新", tokenMap));
        } else {
            return chain.filter(exchange);
        }

/*        DecodedJWT decodedJWT = null;
        if (token == null) {
            return getVoidMono(response, new CommonResult(ResultCode.UNAUTHORIZED, "无Token，重新登录", null));
        } else {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TokenUtil.SECRET_KEY)).build();
            try {
                decodedJWT = jwtVerifier.verify(token);
            }catch (TokenExpiredException e){
                return getVoidMono(response, new CommonResult(ResultCode.FAIL, "Token过期，重新登录", null));
            } catch (JWTDecodeException e) {
            }
            catch (Exception e) {
                return getVoidMono(response, new CommonResult(ResultCode.FAIL, "Token失效，重新登录", null));
            }
        }
        if (decodedJWT != null) {
            String userId = String.valueOf(decodedJWT.getClaim("userId"));
            userId = userId.substring(1, userId.length() - 1);

            Object redisToken = this.redisTemplate.opsForValue().get(userId);
            if (redisToken == null) {
                return getVoidMono(response, new CommonResult(ResultCode.FAIL, "无此用户token，重新登录", null));
            }
            if (!token.equals(redisToken)) {
                return getVoidMono(response, new CommonResult(ResultCode.FAIL, "此用户token以变更，重新登录", null));
            }
        } else {
            return getVoidMono(response, new CommonResult(ResultCode.FAIL, "Token解码错误，重新登录", null));
        }
        return chain.filter(exchange);*/
    }

    private Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse, CommonResult commonResult) {
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(JSON.toJSONString(commonResult).getBytes());
        return serverHttpResponse.writeWith(Mono.just(dataBuffer));
    }
}
