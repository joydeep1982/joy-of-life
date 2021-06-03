package com.joy.of.life.htmlfileworker.listner;

import com.joy.of.life.htmlfileworker.service.URLProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HTMLWorker {

    private static final Logger LOG = LoggerFactory.getLogger(HTMLWorker.class);

    @Autowired
    private URLProcessor urlProcessor;

    @KafkaListener(topics = "html_topic", groupId = "group_id")
    public void consume(String message) {
        LOG.info("Received message: {}", message);
        urlProcessor.process(message);
    }
}


















