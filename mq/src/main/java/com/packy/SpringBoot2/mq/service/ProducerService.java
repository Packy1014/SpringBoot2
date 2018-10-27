package com.packy.SpringBoot2.mq.service;

import javax.jms.Destination;

public interface ProducerService {

    void sendMessage(Destination destination, final String message);

    void sendMessage(final String message);

    void publish(String msg);

}
