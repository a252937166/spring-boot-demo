package com.ouyanglol.demo.config.expection;

import com.ouyanglol.demo.entity.Result;
import com.ouyanglol.demo.entity.ResultException;
import com.ouyanglol.demo.entity.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 统一异常处理
 * @author Ouyang
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ShiroException.class)
    public Result handleShiroException(ShiroException e) {
        String eName = e.getClass().getSimpleName();
        log.error("shiro执行出错：{}",eName);
        return Result.error(ResultStatus.ERROR);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public Result page401(UnauthenticatedException e) {
        log.error("未经授权:{}",e.getMessage());
        return Result.error(ResultStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public Result page403(UnauthorizedException e) {
        log.error("无权限访问:{}",e.getMessage());
        return Result.error(ResultStatus.FORBIDDEN);
    }

    @ExceptionHandler(ResultException.class)
    public Result error(ResultException e) {
        log.error("无权限访问:{}",e.getMessage());
        return Result.error(e.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        log.error("系统异常:{}",e.getMessage());
        return Result.error(ResultStatus.ERROR);
    }

}