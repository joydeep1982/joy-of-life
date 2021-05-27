package com.joy.of.life.htmlfileworker.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HTMLWorker {

    @KafkaListener(topics = "html_topic", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Received message; "  + message);
    }
}
