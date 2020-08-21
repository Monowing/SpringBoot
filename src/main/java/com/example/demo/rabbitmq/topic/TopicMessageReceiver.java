package com.example.demo.rabbitmq.topic;

import com.example.demo.rabbitmq.application.Application;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Application.QUEUE_MESSAGE_NAME)
public class TopicMessageReceiver {

    @RabbitHandler
    public void process(String msg) {

        System.out.println("topicMessageReceiver  : " +msg);

    }

}
