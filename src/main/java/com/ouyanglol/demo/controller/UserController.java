package com.ouyanglol.demo.controller;

import com.ouyanglol.demo.model.User;
import com.ouyanglol.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ouyang
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String list() {
        List<User> userList = userService.all();
        StringBuilder builder = new StringBuilder();
        userList.forEach(user -> builder.append(user.toString()));
        return builder.toString();
    }
}
