package com.ouyanglol.demo.service.impl;

import com.ouyanglol.demo.DemoApplicationTests;
import com.ouyanglol.demo.service.BlogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author ouyangduning
 * @date 2019/11/30 下午6:07
 */
public class BlogServiceImplTest extends DemoApplicationTests {
    @Autowired
    private BlogService blogService;

    @Test
    public void findAll() {
        System.out.println(blogService.findAll());
    }
}