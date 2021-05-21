package com.joy.of.life.urlfeederservice.service;

import com.joy.of.life.urlfeederservice.dao.URLRepository;
import com.joy.of.life.urlfeederservice.model.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    public void save(URL url) {
        urlRepository.save(url);
    }

}
