package com.ouyanglol.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dnouyang
 * @Date: 2018/12/7 16:44
 */
@Slf4j
public class LogTest {

    @Test
    public void log() {
        Map<String,Object> map = new HashMap<>();
        map.put(null,null);
        for (String key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key).toString());
        }

    }
}
