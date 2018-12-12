package com.ouyanglol.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @RequiresAuthentication
    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("error")
    public String getV2() {
        log.info("hehehh");
        int a = 1/0;
        return "ERROR";
    }
}
