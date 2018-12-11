package com.ouyanglol.demo.service;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.demo.model.User;

/**
 * @author Ouyang
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return 用户列表
     */
    PageInfo<User> all();


    /**
     * 根据主键查找用户
     * @param id id
     * @return 用户
     */
    User selectById(String id);

    /**
     * 根据主键查找用户
     * @param id id
     * @return 用户
     */
    User selectByIdV2(String id);

}
