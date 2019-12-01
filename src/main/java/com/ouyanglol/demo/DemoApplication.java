package com.ouyanglol.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ouyang
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ouyanglol.demo.dao")
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors","false");
        SpringApplication.run(DemoApplication.class, args);
    }
}
