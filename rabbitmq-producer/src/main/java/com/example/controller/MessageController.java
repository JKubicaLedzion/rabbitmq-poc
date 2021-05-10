package com.example.controller;

import com.example.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/message")
public class MessageController {

    private MessageProducer messageProducer;

    @Autowired
    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public ResponseEntity<String> sentMessage(@RequestParam("message") String message) {
        log.info("Controller received message: " + message);
        messageProducer.produceMessage(message);
        return ResponseEntity.ok().build();
    }
}
