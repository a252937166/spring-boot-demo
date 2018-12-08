package com.ouyanglol.demo.dao;

import com.ouyanglol.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDAO继承基类
 * @author Ouyang
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, String> {
    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<User> selectAll();
}