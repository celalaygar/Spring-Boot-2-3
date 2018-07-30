package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Details;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DetailsRepository;

@RestController
public class MainController {

	@Autowired
    DetailsRepository detailsRepository;
     
    @Autowired
    CustomerRepository customerRepository;
    
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		
		return "Hello World";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert() {
		System.out.println("-----------------------------------------------------------------------------------------------");
		detailsRepository.deleteAll();
        customerRepository.deleteAll();
        Details lisa = new Details("Hannover","Germany","05558882211", new Customer("fatih","fatih@gmail.com"));
        detailsRepository.save(lisa);
        Details mary = new Details("London","England","05551112233",  new Customer("celal","celal@gmail.com"));
        Details lauren = new Details("Ankara","Turkey","05441114499", new Customer("aylin","aylin@gmail.com"));
        detailsRepository.saveAll(Arrays.asList(mary,lauren));
		
		return "insert Data..................";
	}
}
