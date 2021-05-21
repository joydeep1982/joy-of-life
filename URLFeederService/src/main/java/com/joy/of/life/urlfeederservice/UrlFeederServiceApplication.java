package com.joy.of.life.urlfeederservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.joy.of.life.urlfeederservice.dao")
public class UrlFeederServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlFeederServiceApplication.class, args);
	}

}
