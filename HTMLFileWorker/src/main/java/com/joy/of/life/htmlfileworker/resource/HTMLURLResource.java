package com.joy.of.life.htmlfileworker.resource;


import com.joy.of.life.htmlfileworker.service.URLProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HTMLURLResource {

    private static final Logger LOG = LoggerFactory.getLogger(HTMLURLResource.class);

    @Autowired
    private URLProcessor urlProcessor;

    @PostMapping
    public ResponseEntity<Void> submitURL(@RequestBody String url) {
        LOG.info("URL received: {}", url);
        urlProcessor.process(url);
        return ResponseEntity.ok().build();
    }
}
