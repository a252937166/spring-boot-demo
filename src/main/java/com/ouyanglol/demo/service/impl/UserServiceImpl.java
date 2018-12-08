package com.ouyanglol.demo.service.impl;

import com.ouyanglol.demo.dao.UserDAO;
import com.ouyanglol.demo.model.User;
import com.ouyanglol.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ouyang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> all() {
        return userDAO.selectAll();
    }
}
