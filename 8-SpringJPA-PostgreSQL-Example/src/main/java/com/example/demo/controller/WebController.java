package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.model.Customer;

@RestController
public class WebController {
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/save")
	public String process(){
		// save a single Customer
		repository.save(new Customer("Jack", "Watsenn"));
		
		// save a list of Customers
		repository.saveAll(Arrays.asList(new Customer("Muharrem", "İnce"),new Customer("Fatih", "Yardımcı"),
				new Customer("Fatih", "Terim"),new Customer("Celal", "Aygar"),
				new Customer("Adem", "Yılmaz"), new Customer("Kim Kissle", "Kardishian"),
				new Customer("David", "Backhem"), new Customer("Peter Hard", "John")));
		
		return "Done";
	}
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "";
		
		for(Customer cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}
		
		return result;
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findById(id).toString();
		return result;
	}
	
	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "";
		
		for(Customer cust: repository.findByLastName(lastName)){
			result += cust.toString() + "<br>"; 
		}
		
		return result;
	}
}