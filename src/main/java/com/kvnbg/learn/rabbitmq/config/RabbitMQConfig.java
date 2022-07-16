package com.kvnbg.learn.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue testeQueue() {
        return new Queue("teste", true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("exchange-teste");
    }

    @Bean
    public Binding testeBinding(Queue testeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(testeQueue).to(exchange).with("routing-key-teste");
    }
}
