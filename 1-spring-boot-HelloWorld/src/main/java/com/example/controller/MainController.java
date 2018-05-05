package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String helloMain(){
		
		
		return "hello main";
	}
	@GetMapping("/welcome")
	public String helloWorld(){
		
		
		return "hello world";
	}
	
}
