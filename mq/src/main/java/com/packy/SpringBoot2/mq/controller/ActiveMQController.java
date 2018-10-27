package com.packy.SpringBoot2.mq.controller;

import com.packy.SpringBoot2.mq.domain.JsonData;
import com.packy.SpringBoot2.mq.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
@RequestMapping("/active_mq")
public class ActiveMQController {

    private final ProducerService producerService;

    @Autowired
    public ActiveMQController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("send_msg_to_queue")
    public Object sendMsgToQueue(String queueName, String msg) {
        Destination destination = new ActiveMQQueue(queueName);
        producerService.sendMessage(destination, msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("send_msg_to_common_queue")
    public Object sendMsgToCommonQueue(String msg) {
        producerService.sendMessage(msg);
        return JsonData.buildSuccess();
    }

    @GetMapping("send_msg_to_common_topic")
    public Object sendMsgToCommonTopic(String msg) {
        producerService.publish(msg);
        return JsonData.buildSuccess();
    }

}
