package com.ouyanglol.demo.controller;

import com.ouyanglol.demo.DemoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Ouyang
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