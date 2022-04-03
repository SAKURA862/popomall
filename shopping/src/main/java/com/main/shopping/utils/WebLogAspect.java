package com.main.shopping.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.main.shopping.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog() {
    }//签名，可以理解成这个切入点的一个名称

    //统计请求的处理时间
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 记录下请求内容
        log.info("######### URL : " + request.getRequestURL().toString());
        log.info("######### HTTP_METHOD : " + request.getMethod());
        log.info("######### IP : " + request.getRemoteAddr());
        log.info("######### THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        log.info("######### CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("######### TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        //logger.info("######### THIS: " + joinPoint.getThis());//返回的是经过加强后的代理类的对象

        log.info("######### request time : {}", new Date());
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) {
        //处理完请求后，返回内容
        log.info("######### return message : {}", JSON.toJSONString(ret));
        log.info("######### execution time : {}", System.currentTimeMillis() - startTime.get());
    }

    @AfterThrowing(throwing = "thr", pointcut = "controllerLog()")
    public void doAfterThrowing(Throwable thr) {
        //处理完请求后，返回内容
        log.warn("######### throw message : {}", thr.getMessage());
        log.info("######### execution time : {}", System.currentTimeMillis() - startTime.get());
        startTime.remove();
    }
}