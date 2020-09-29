package com.example.demo.rabbitmq.direct;

import com.example.demo.rabbitmq.application.Application;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {

        String msgString="directSender :hello i am hzb";

        System.out.println(msgString);

        this.rabbitTemplate.convertAndSend(Application.DIRECT_QUEUE_NAME, msgString);

    }

}
