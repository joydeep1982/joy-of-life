package com.joy.of.life.htmlfileworker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@Document(collection = "html_page")
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo {

    @Id
    private String id;

    @Field(name = "url_id")
    private String urlId;

    private String url;

    private String title;

    private List<String> keywords;

    private String description;

    private String body;

    @Field(name = "created_time")
    private Timestamp createdTime;
}
