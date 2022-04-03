package com.main.browse.exception;

import com.main.api.common.CommonResult;
import com.main.api.common.ResultCode;
import com.main.api.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.warn("参数校验异常:{}({})", fieldError.getDefaultMessage(), fieldError.getField());
        return new CommonResult(ResultCode.FAIL, fieldError.getDefaultMessage(), fieldError.getDefaultMessage());
    }


    @ResponseBody
    @ExceptionHandler(IllegalPasswordException.class)
    public CommonResult illegalPasswordException(IllegalPasswordException e) {
        String message = e.getMessage();
        log.warn("参数校验异常:{}", message);
        return new CommonResult(ResultCode.FAIL, message, message);
    }

    @ResponseBody
    @ExceptionHandler(NoResultException.class)
    public CommonResult noResultException(NoResultException e) {
        String message = e.getMessage();
        log.warn("查询无结果:{}", message);
        return CommonResult.noneResult(message, message);
    }

    @ResponseBody
    @ExceptionHandler(UserAlreadyExistException.class)
    public CommonResult userAlreadyExistException(UserAlreadyExistException e) {
        String message = e.getMessage();
        log.warn("重复添加:{}", message);
        return CommonResult.noneResult(message, message);
    }

    @ResponseBody
    @ExceptionHandler(UpdateFailException.class)
    public CommonResult updateFailException(UpdateFailException e) {
        String message = e.getMessage();
        log.warn("更新异常:{}", message);
        return CommonResult.noneResult(message, message);
    }

    @ResponseBody
    @ExceptionHandler(InsertFailException.class)
    public CommonResult insertFailException(InsertFailException e) {
        String message = e.getMessage();
        log.warn("插入异常:{}", message);
        return CommonResult.noneResult(message, message);
    }

    @ResponseBody
    @ExceptionHandler(DeleteFailException.class)
    public CommonResult deleteFailException(DeleteFailException e) {
        String message = e.getMessage();
        log.warn("删除异常:{}", message);
        return CommonResult.noneResult(message, message);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult otherExceptions(Exception e) {
        String detail = e.toString();
        log.warn("发生异常:{}", detail);
        return CommonResult.noneResult("出错啦~ ๐·°(৹˃̵﹏˂̵৹)°·๐ ", "出错啦~ ๐·°(৹˃̵﹏˂̵৹)°·๐ ");
    }

}
