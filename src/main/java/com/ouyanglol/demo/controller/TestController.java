package com.ouyanglol.demo.controller;

import com.ouyanglol.demo.config.mq.DemoProducer;
import com.ouyanglol.demo.entity.ComicUrl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    @Autowired
    private DemoProducer producer;

    @RequiresAuthentication
    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("error")
    public String getV2() {
        log.info("hehehh");
//        int a = 1/0;
        return "ERROR";
    }

    @GetMapping("mh")
    public String mh(@RequestParam String url) throws IOException {
        String pattern = "var\\s+mhurl\\s*=\\s*\"(.*?)(\";){1}";
        Pattern r = Pattern.compile(pattern);
        String pattern2 = "<a\\s+href=\"(.*?)\"\\s+class=\"pure-button pure-button-primary\">下一页</a>";
        Pattern r2 = Pattern.compile(pattern2);
        Document doc = Jsoup.connect(url).get();
        String orignUrl = doc.getElementById("readurl").attributes().get("content");
        Matcher m = r.matcher(doc.body().toString());
        if (m.find()) {
            String mhurl = m.group(1);
            String mhss = "p1.xiaoshidi.net";
            if (!mhurl.contains("2016") && !mhurl.contains("2017") && !mhurl.contains("2018") && !mhurl.contains("2019")) {
                mhss = "p0.xiaoshidi.net";
            }
            String mhpicurl = "http://" + mhss + "/" + mhurl;
            if (mhurl.contains("http")) {
                mhpicurl = mhurl;
            }
            String fileName = "海贼王" + mhurl.substring(mhurl.lastIndexOf("/") + 1);
            ComicUrl comicUrl = new ComicUrl(fileName, mhpicurl);
            System.out.println(fileName + ":" + mhpicurl);
            System.out.println("存入队列.....");
            producer.send(comicUrl);
            Matcher m2 = r2.matcher(doc.body().toString());
            if (m2.find()) {
                String newUrl = orignUrl + m2.group(1);
                mh(newUrl);
            }
        }
        return "finish";
    }
}
