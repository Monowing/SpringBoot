package com.example.demo.rabbitmq.direct;

import com.example.demo.rabbitmq.application.Application;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Application.DIRECT_QUEUE_NAME)
public class DirectReceiver {

    @RabbitHandler
    public void process(String msg) {

        System.out.println("directReceiver  : " + msg);

    }

}