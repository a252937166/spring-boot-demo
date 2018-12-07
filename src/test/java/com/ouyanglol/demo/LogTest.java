package com.ouyanglol.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author: dnouyang
 * @Date: 2018/12/7 16:44
 */
@Slf4j
public class LogTest extends DemoApplicationTests {

    @Test
    public void log() {
        log.info("this a is log {}","message");
    }
}
