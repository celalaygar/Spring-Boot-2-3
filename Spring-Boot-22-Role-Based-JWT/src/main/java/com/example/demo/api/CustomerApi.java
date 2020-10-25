package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApi {

	@GetMapping("/api/customer/all")
	public ResponseEntity<String> hello(){
		
		return ResponseEntity.ok("customer customer");
	}
}
