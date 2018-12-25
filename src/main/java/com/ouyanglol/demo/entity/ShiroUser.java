package com.ouyanglol.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ouyang
 * @date 18/12/16 23:36
 */
@Data
public class ShiroUser implements Serializable {
    private Long id;
    private String username;
    private String nick;
    private String pwd;
}
