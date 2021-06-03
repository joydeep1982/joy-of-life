package com.joy.of.life.htmlfileworker.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class URL {

    String id;

    String url;

    Integer timesProcessed;

    String contentType;

    Timestamp lastProcessed;

    Timestamp createdDate;
}






















