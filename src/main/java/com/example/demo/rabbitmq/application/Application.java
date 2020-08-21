package com.example.demo.rabbitmq.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application {

    public static final String HELLO_QUEUE_NAME = "helloQueue";

    public static final String USER_QUEUE_NAME = "userQueue";

    public static final String DIRECT_QUEUE_NAME = "directQueue";

    public static final String DIRECT_EXCHANGE_NAME = "directExchange";

    public static final String QUEUE_MESSAGE_NAME = "topic.message";

    public static final String QUEUE_MESSAGES_NAME = "topic.messages";

    public static final String TOPIC_EXCHANGE_NAME = "topicExchange";

    public static final String FINAL_EXCHANGE_NAME = "fanoutExchange";

    private static Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean
    public Queue helloQueue() {
        return new Queue(HELLO_QUEUE_NAME);
    }

    @Bean
    public Queue userQueue() {
        return new Queue(USER_QUEUE_NAME);
    }

    //-----------以下是验证Direct模式------------//
    @Bean
    public Queue directQueue() {
        return new Queue(DIRECT_QUEUE_NAME);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME);
    }

    @Bean
    Binding bindingExchangeDirect() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(DIRECT_EXCHANGE_NAME);
    }
    //-----------以上是验证Direct模式------------//

    //-----------以下是验证Topic模式------------//

    @Bean(name = "message")
    public Queue queueMessage() {
        return new Queue(QUEUE_MESSAGE_NAME);
    }


    @Bean(name = "messages")
    public Queue queueMessages() {
        return new Queue(QUEUE_MESSAGES_NAME);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    /**
     * 将队列topic.message与exchange绑定，routing_key为topic.message,就是完全匹配
     *
     * @return
     */
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(queueMessage()).to(topicExchange()).with(QUEUE_MESSAGE_NAME);
    }

    /**
     * 将队列topic.messages与exchange绑定，routing_key为topic.#,模糊匹配
     *
     * @return
     */
    @Bean
    Binding bindingExchangeMessages() {
        //1.完全匹配
//        return BindingBuilder.bind(queueMessages()).to(topicExchange()).with(QUEUE_MESSAGES_NAME);
        // 2.模糊匹配
        return BindingBuilder.bind(queueMessages()).to(topicExchange()).with("topic.#");
    }

    //-----------以上是验证Topic模式------------//


    //-----------以下是验证Fanout模式------------//


    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FINAL_EXCHANGE_NAME);
    }


    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(AMessage()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(BMessage()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(CMessage()).to(fanoutExchange());
    }


    //-----------以上是验证Fanout模式------------//


    @Bean
    public RabbitTemplate rabbitTemplate() {

        //若使用confirm-callback或return-callback，必须要配置publisherConfirms或publisherReturns为true
        //每个rabbitTemplate只能有一个confirm-callback和return-callback，如果这里配置了，那么写生产者的时候不能再写confirm-callback和return-callback
        //使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        /**
         * 如果消息没有到exchange,则confirm回调,ack=false
         * 如果消息到达exchange,则confirm回调,ack=true
         * exchange到queue成功,则不回调return
         * exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
         */
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    log.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause);
                } else {
                    log.info("消息发送失败:correlationData({}),ack({}),cause({})", correlationData, ack, cause);
                }
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message);
            }
        });
        return rabbitTemplate;
    }

}
