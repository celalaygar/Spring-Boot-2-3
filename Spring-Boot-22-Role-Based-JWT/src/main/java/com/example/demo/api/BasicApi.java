package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicApi {

	@GetMapping("/api/basic/all")
	public ResponseEntity<String> hello(){
		
		return ResponseEntity.ok("basic basic");
	}
}
