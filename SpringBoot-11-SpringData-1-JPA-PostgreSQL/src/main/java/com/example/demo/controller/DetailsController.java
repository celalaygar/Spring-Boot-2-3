package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Details;
import com.example.demo.repository.DetailsRepository;
@RestController
public class DetailsController {

	@Autowired
    DetailsRepository detailsRepository;
	
	@ResponseBody
	@GetMapping("/detail/{id}")
	public String FindDetailById(@PathVariable Long id) {
		Optional<Details> details=detailsRepository.findById(id);
		return ""+details.get();
	}
	
	
	@GetMapping("/detailjson/{id}")
	public ResponseEntity<Details> FindDetailByIdJson(@PathVariable Long id) {
		Optional<Details> details=detailsRepository.findById(id);
		return ResponseEntity.ok(details.get());
	}
    
	@ResponseBody
	@GetMapping("/details")
	public String Customers() {
		List<Details> details = detailsRepository.findAll();
		String result = "";
		for(Details det : details){
			result += det.toString() + "<br>";
		}
		return result;
	}
	
}
