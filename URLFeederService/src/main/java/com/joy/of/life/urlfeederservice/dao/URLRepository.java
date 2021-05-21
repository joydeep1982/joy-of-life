package com.joy.of.life.urlfeederservice.dao;

import com.joy.of.life.urlfeederservice.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URL, String> {
}
