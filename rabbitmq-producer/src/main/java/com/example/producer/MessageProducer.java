package com.example.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageProducer {

    static final String topicExchangeName = "message-exchange";

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceMessage(String message) {
        log.info("Producer is producing message: " + message);
        rabbitTemplate.convertAndSend(topicExchangeName, "message.text", message);
    }
}
