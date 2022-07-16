package com.kvnbg.learn.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Value("${queue.name}")
    public String queueName;

    @Bean
    public Queue queue() {
        return new Queue(queueName, true);
    }
}
