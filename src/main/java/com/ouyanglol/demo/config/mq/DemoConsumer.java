package com.ouyanglol.demo.config.mq;

import com.google.gson.internal.LinkedTreeMap;
import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import com.ouyanglol.demo.entity.ComicUrl;
import com.ouyanglol.demo.util.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@MQConsumer(topic = "${rocketmq.topic}", consumerGroup = "${rocketmq.consumer-group}")
public class DemoConsumer extends AbstractMQPushConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        if (message instanceof LinkedTreeMap) {
            String fileName = (String) ((LinkedTreeMap) message).get("name");
            String url = (String) ((LinkedTreeMap) message).get("url");
            System.out.println("开始上传:"+fileName);
            QiniuUtil.uploadImg(url,fileName);
            System.out.println(fileName+":上传完毕");
        }
        return true;
    }

    public byte[] getImgBytes(String url) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<byte[]>(headers),
                byte[].class);

        byte[] result = response.getBody();
        return result;
    }
}