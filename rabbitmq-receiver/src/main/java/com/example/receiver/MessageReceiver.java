package com.example.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void receiveMessage(String message) throws InterruptedException {
        log.info("Receiver1 received message: " + message);
        Thread.sleep(1000);
    }
}
