package com.joy.of.life.htmlfileworker.service;

import com.joy.of.life.htmlfileworker.dao.PageRepository;
import com.joy.of.life.htmlfileworker.model.PageInfo;
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
import retrofit2.Retrofit;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Service
public class URLProcessor {

    private static final Logger LOG = LoggerFactory.getLogger(URLProcessor.class);

    @Autowired
    private Retrofit retrofit;

    @Autowired
    private PageRepository pageRepository;

    @Async
    public void process(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            Set<URL> urls = fetchAnchorTags(doc);
            PageInfo pageInfo = fetchMetaInformation(doc);
            pageInfo.setUrlId(UUID.randomUUID().toString());
            pageInfo.setUrl(url);
            LOG.info("PageInfo: {}", pageInfo);
            pageRepository.save(pageInfo);
//            Response<Void> response = retrofit.create(URLFeederService.class).batchPublish(urls).execute();
//            if (!response.isSuccessful()) {
//                LOG.info("Retrofit called failed, with response code {}", response.code());
//            }
        } catch (IOException ex) {
            LOG.error("Exception: ", ex);
        }
    }

    private PageInfo fetchMetaInformation(Document doc) {
        return PageInfo.builder()
                .id(UUID.randomUUID().toString())
                .title(doc.title())
                .description(description(doc))
                .body(body(doc))
                .keywords(keywords(doc))
                .createdTime(new Timestamp(System.currentTimeMillis()))
                .build();
    }

    private String body(Document doc) {
        return doc.body().text();
    }

    private String description(Document doc) {
        Elements ele = doc.select("meta[name=description]");
        if (!ele.isEmpty()) {
            return ele.first().attr("content");
        }
        return null;
    }

    private List<String> keywords(Document doc) {
        Elements ele = doc.select("meta[name=keywords]");
        if(!ele.isEmpty()) {
            String keywords = ele.first().attr("content");
            return Arrays.asList(keywords.split(","));
        }
        return Collections.emptyList();
    }

    public Set<URL> fetchAnchorTags(Document doc) {
        Set<URL> urls = new HashSet<>();
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String path = link.attr("href");
            urls.add(URL.builder().url(path).build());
        }
        return urls;
    }
}





















