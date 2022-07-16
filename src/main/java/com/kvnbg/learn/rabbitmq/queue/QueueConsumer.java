package com.kvnbg.learn.rabbitmq.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload Message<String> message) {
        System.out.println("Message " + message.getPayload());
        System.out.println("Headers " + message.getHeaders().get("headerTeste"));
    }
}
