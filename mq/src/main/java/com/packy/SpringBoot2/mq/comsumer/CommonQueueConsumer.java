package com.packy.SpringBoot2.mq.comsumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CommonQueueConsumer {
    @JmsListener(destination = "common.queue")
    public void receiveQueue(String text) {
        System.out.println("CommonQueueConsumer收到的报文为:" + text);
    }
}
