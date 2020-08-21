package com.example.demo.rabbitmq.hello;

import com.example.rabbitmq.application.Application;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Application.HELLO_QUEUE_NAME)
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}
