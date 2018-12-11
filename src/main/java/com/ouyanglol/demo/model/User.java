package com.ouyanglol.demo.model;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5186576718292658281L;
    private String id;

    /**
     * 用户名
     */
    private String username;

    private String sex;

    private Integer age;

}