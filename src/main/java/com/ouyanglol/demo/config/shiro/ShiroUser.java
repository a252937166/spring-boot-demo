package com.ouyanglol.demo.config.shiro;

import lombok.Data;

/**
 * @date 18/12/16 23:36
 */
@Data
public class ShiroUser {
    private Long id;
    private String username;
    private String nick;
    private String pwd;
}
