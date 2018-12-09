package com.ouyanglol.demo.controller;

import com.github.pagehelper.PageInfo;
import com.ouyanglol.demo.model.User;
import com.ouyanglol.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ouyang
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String list() {
        PageInfo<User> pageInfo = userService.all();
        log.info("total-->{}",pageInfo.getTotal());
        StringBuilder builder = new StringBuilder();
        pageInfo.getList().forEach(user -> builder.append(user.toString()));
        log.info("userList-->{}",builder.toString());
        log.info("一共{}页",pageInfo.getPages());
        return builder.toString();
    }
}
