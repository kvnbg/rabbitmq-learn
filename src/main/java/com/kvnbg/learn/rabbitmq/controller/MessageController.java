package com.kvnbg.learn.rabbitmq.controller;

import com.kvnbg.learn.rabbitmq.queue.QueueProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping
public class MessageController {

    @Autowired
    private QueueProducer queueProducer;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/queue")
    public String send() {
        queueProducer.send("Producer send a message");
        return "Ok. Message send";
    }

    @GetMapping("/exchange")
    public String sendExchangeMessage() {
        amqpTemplate.convertAndSend("exchange-teste", "routing-key-teste", "Test send message to exchange");
        return "Ok. Message send";
    }

    @GetMapping("/exchange-headers")
    public String sendExchangeMessageWithHeaders() {

        String textMessage = "Test send message to exchange";
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("headerTeste", "teste");

        Message message = new Message(textMessage.getBytes(StandardCharsets.UTF_8), messageProperties);

        amqpTemplate.convertAndSend("exchange-teste", "routing-key-teste", message);
        return "Ok. Message send";
    }
}
