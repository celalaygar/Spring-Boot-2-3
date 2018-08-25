package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CustomerRepository;

@RestController
public class MainController {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		
		return "Hello World";
	}

}
