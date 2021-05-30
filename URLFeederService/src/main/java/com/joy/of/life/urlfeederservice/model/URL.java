package com.joy.of.life.urlfeederservice.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "url")
public class URL {

    @Id
    String id;

    String url;

    @Column(name = "times_processed")
    Integer timesProcessed;

    @Column(name = "content_type")
    String contentType;

    @Column(name = "last_processed")
    Timestamp lastProcessed;

    @Column(name = "created_date")
    Timestamp createdDate;
}






















