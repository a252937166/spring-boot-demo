package com.ouyanglol.demo.config.mq;

import com.maihaoche.starter.mq.annotation.MQProducer;
import com.maihaoche.starter.mq.base.AbstractMQProducer;
import com.maihaoche.starter.mq.base.MessageBuilder;
import com.ouyanglol.demo.entity.ComicUrl;
import org.springframework.beans.factory.annotation.Value;

@MQProducer
public class DemoProducer extends AbstractMQProducer {

    @Value("${rocketmq.topic}")
    private String topic;

    public void send(ComicUrl s) {
        this.syncSend(MessageBuilder.of(s).topic(topic).build());
    }
}