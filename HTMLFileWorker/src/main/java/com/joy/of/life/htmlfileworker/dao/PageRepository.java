package com.joy.of.life.htmlfileworker.dao;

import com.joy.of.life.htmlfileworker.model.PageInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PageRepository extends MongoRepository<PageInfo, String> {

    @Query("{urlId : ?0}")
    PageInfo findByUrlId(String id);
}
