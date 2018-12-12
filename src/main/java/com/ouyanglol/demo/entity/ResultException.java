package com.ouyanglol.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Ouyang
 * @date 18/12/16 19:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ResultException extends RuntimeException {
    private static final long serialVersionUID = 5851018172703811098L;

    public ResultException(ResultStatus status){
        this.status = status;
    }
    private ResultStatus status;
}
