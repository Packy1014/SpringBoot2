package com.packy.SpringBoot2.mq.comsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CommonTopicConsumer {

    @JmsListener(destination = "common.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive1(String text) {
        System.out.println("video.topic 消费者:receive1=" + text);
    }


    @JmsListener(destination = "common.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive2(String text) {
        System.out.println("video.topic 消费者:receive2=" + text);
    }


    @JmsListener(destination = "common.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive3(String text) {
        System.out.println("video.topic 消费者:receive3=" + text);
    }

}
