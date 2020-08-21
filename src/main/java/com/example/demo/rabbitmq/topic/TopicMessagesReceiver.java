package com.example.demo.rabbitmq.topic;

import com.example.rabbitmq.application.Application;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Application.QUEUE_MESSAGES_NAME)
public class TopicMessagesReceiver {

    @RabbitHandler
    public void process(String msg) {

        System.out.println("topicMessagesReceiver  : " +msg);

    }
}