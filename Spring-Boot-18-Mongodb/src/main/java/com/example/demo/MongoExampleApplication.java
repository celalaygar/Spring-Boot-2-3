package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.repo.KullaniciRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MongoExampleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MongoExampleApplication.class, args);
	}

}
