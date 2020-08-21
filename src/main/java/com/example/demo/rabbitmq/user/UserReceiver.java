package com.example.demo.rabbitmq.user;

import com.example.rabbitmq.application.Application;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Application.USER_QUEUE_NAME)
public class UserReceiver {

    @RabbitHandler
    public void process(User user){
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }
}
