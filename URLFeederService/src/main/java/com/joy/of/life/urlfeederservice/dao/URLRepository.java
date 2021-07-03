package com.joy.of.life.urlfeederservice.dao;

//public interface URLRepository extends JpaRepository<URL, String> {
//
//    @Query("SELECT u FROM URL u WHERE u.url = ?1")
//    URL findByURL(String url);
//}


import com.joy.of.life.urlfeederservice.model.URL;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLRepository extends CassandraRepository<URL, String> {

    @AllowFiltering
    Optional<URL> findByUrl(String url);

    @AllowFiltering
    Optional<URL> findById(String id);
}