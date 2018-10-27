package com.packy.SpringBoot2.mq.service.impl;

import com.packy.SpringBoot2.mq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final Queue commonQueue;

    private final Topic commonTopic;

    private final JmsMessagingTemplate jmsTemplate;

    @Autowired
    public ProducerServiceImpl(Queue commonQueue, JmsMessagingTemplate jmsTemplate, Topic commonTopic) {
        this.commonQueue = commonQueue;
        this.jmsTemplate = jmsTemplate;
        this.commonTopic = commonTopic;
    }

    @Override
    public void sendMessage(Destination destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

    @Override
    public void sendMessage(final String message) {
        jmsTemplate.convertAndSend(this.commonQueue, message);
    }

    @Override
    public void publish(String msg) {
        this.jmsTemplate.convertAndSend(this.commonTopic, msg);
    }

}
