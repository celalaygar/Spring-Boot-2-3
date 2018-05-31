package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.CustomerRepository;

@SpringBootApplication
public class SpringJpaPostgreSqlExampleApplication implements CommandLineRunner {
	@Autowired
	CustomerRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPostgreSqlExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.deleteAll();
	}
}
