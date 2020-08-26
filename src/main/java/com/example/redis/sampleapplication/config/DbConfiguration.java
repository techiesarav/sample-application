package com.example.redis.sampleapplication.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DbConfiguration {

	@Autowired
	DataSource datasource;
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(datasource);
	}
	
	@Bean
	NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(datasource);
	}
	
}
