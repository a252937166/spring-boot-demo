package com.ouyanglol.demo.service;

import com.ouyanglol.demo.model.User;

import java.util.List;

/**
 * @author Ouyang
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return 用户列表
     */
    public List<User> all();

}
