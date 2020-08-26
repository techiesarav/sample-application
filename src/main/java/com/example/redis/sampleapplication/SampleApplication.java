package com.example.redis.sampleapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.redis.sampleapplication.dao.AccountDao;

@SpringBootApplication
@EnableCaching
public class SampleApplication{

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

}
