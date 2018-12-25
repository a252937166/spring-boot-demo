package com.ouyanglol.demo.entity;

import lombok.Data;

/**
 * @Date: 2018/12/24 16:46
 */
@Data
public class ComicUrl {
    public ComicUrl(String name,String url) {
        this.name = name;
        this.url = url;
    }
    private String name;
    private String url;
}
