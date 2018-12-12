package com.ouyanglol.demo.entity;

import org.springframework.http.HttpStatus;

/**
 * @author Ouyang
 * @date 18/12/13 22:23
 */
public enum ResultStatus {
    /**
     * 请求成功
     */
    SUCCESS(HttpStatus.OK,"成功"),

    /**
     * 请求失败
     */
    ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"失败"),

    /**
     * 未授权
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"未经授权"),

    /**
     * 请求无权限
     */
    FORBIDDEN(HttpStatus.FORBIDDEN,"无权限");

    private HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    private String message;
    ResultStatus(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }
}
