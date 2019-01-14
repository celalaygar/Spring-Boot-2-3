package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;

@SpringBootApplication
public class SpringManytomanyApplication  {


	public static void main(String[] args) {
		SpringApplication.run(SpringManytomanyApplication.class, args);
	}


}

