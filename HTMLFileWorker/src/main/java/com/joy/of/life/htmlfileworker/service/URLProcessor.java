package com.joy.of.life.htmlfileworker.service;

import com.joy.of.life.htmlfileworker.client.URLFeederService;
import com.joy.of.life.htmlfileworker.model.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class URLProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(URLProcessor.class);

    @Autowired
    private Retrofit retrofit;

    @Async
    public void process(String url) {
        try {
            Set<URL> urls = new HashSet<>();
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String path = link.attr("href");
                LOG.info("Extracted: {}", path);
                urls.add(URL.builder().url(path).build());
            }
            Response<Void> response = retrofit.create(URLFeederService.class).batchPublish(urls).execute();
            if (!response.isSuccessful()) {
                LOG.info("Retrofit called failed, with response code {}", response.code());
            }
        } catch (IOException ex) {
            LOG.error("Exception: ", ex);
        }
    }
}





















