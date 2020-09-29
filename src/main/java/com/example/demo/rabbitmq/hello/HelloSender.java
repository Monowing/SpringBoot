package com.example.demo.rabbitmq.hello;


import com.example.demo.rabbitmq.application.Application;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {

        String sendMsg = "hello " + new Date();

        System.out.println("Sender : " + sendMsg);

        this.rabbitTemplate.convertAndSend(Application.HELLO_QUEUE_NAME, sendMsg);

    }

    public void send(String msg) {

        String sendMsg = msg + new Date();

        System.out.println("Sender1 : " + sendMsg);

        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);

    }
}
