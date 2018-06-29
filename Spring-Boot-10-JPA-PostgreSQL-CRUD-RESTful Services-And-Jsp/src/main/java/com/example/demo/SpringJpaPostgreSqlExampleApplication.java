package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.dao.CustomerCrudRepository;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.demo.controller","com.example.demo.service","com.example.demo.dao"})
public class SpringJpaPostgreSqlExampleApplication implements CommandLineRunner {
	@Autowired
	CustomerCrudRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPostgreSqlExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.deleteAll();
	}
}
