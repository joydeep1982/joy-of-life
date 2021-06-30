package com.joy.of.life.htmlfileworker.dao;

import com.joy.of.life.htmlfileworker.model.PageInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends MongoRepository<PageInfo, String> {
}
