package com.joy.of.life.urlfeederservice.model;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.sql.Timestamp;

//@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "url")
@Table("url")
public class URL implements Serializable {

//    @Id
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    String id;

    @PrimaryKeyColumn(name = "url", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    String url;

//    @Column(name = "times_processed")
    @Column("times_processed")
    Integer timesProcessed;

//    @Column(name = "content_type")
    @Column("content_type")
    String contentType;

//    @Column(name = "last_processed")
    @Column("last_processed")
    Timestamp lastProcessed;

//    @Column(name = "created_date")
    @Column("created_date")
    Timestamp createdDate;
}






















