package com.ouyanglol.demo.controller;

import com.ouyanglol.demo.DemoApplicationTests;
import com.ouyanglol.demo.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @date 18/12/8 21:23
 */
public class UserControllerTest  extends DemoApplicationTests {

    @Autowired
    private UserController userController;

    @Test
    public void list() {
        assertNotNull(userController.list());
    }
}