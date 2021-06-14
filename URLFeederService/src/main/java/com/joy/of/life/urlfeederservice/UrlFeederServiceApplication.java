package com.joy.of.life.urlfeederservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@ComponentScan
@SpringBootApplication
@EnableCassandraRepositories
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories(basePackages = "com.joy.of.life.urlfeederservice.dao")
public class UrlFeederServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlFeederServiceApplication.class, args);
	}
}
