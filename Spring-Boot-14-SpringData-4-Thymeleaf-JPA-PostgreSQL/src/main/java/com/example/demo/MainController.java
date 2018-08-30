package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Controller
public class MainController {

	@Autowired
	CustomerRepository customerRepository;
 
	// inject via application.properties
	@Value("${welcome.message}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}
	@RequestMapping("/customers")
	public String customers(Map<String, Object> model) {
		List<Customer> customers=(List<Customer>) customerRepository.findAll();
		
		model.put("message", this.message);
		model.put("customers", customers);
		return "customers";
	}
	
}
