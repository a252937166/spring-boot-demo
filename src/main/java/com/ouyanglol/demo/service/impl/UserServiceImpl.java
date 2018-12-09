package com.ouyanglol.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyanglol.demo.dao.UserDAO;
import com.ouyanglol.demo.model.User;
import com.ouyanglol.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Ouyang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public PageInfo<User> all() {
        //开始分页，查询第1页，每页3条数据
        PageHelper.startPage(1,3);
        return new PageInfo<>(userDAO.selectAll());
    }
}
