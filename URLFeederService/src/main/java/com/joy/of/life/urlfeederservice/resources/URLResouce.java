package com.joy.of.life.urlfeederservice.resources;

import com.joy.of.life.urlfeederservice.common.Constants;
import com.joy.of.life.urlfeederservice.model.URL;
import com.joy.of.life.urlfeederservice.service.URLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.UUID;

@RestController
public class URLResouce {

    private static final Logger LOG = LoggerFactory.getLogger(URLResouce.class);

    @Autowired
    private URLService urlService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping
    public ResponseEntity<Void> submitURL(@RequestBody URL url) {
        url.setId(Constants.URL_UUID_PREFIX + UUID.randomUUID().toString());
        url.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        url.setTimesProcessed(0);
        LOG.info("URL received: {}", url);
        urlService.save(url);
        return ResponseEntity.ok().build();
    }
}

