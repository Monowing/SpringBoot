package com.example.demo.rabbitmq.fanout;

import com.example.demo.rabbitmq.application.Application;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString = "fanoutSender :hello i am hzb";
        System.out.println(msgString);
        // 参数2被忽略
        this.rabbitTemplate.convertAndSend(Application.FINAL_EXCHANGE_NAME, "", msgString);
    }

}