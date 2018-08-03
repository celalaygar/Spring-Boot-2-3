package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;
	
	@ResponseBody
	@GetMapping("/customer/{id}")
	public String FindHusbandById(@PathVariable Long id) {
		Optional<Customer> customer=customerRepository.findById(id);
		return ""+customer.get().toString();
	}
	
	@GetMapping("/customerjson/{id}")
	public ResponseEntity<Customer> FindHusbandsByIdExtra(@PathVariable Long id) {
		Optional<Customer> customer=customerRepository.findById(id);
		return ResponseEntity.ok(customer.get());
	}
	
	@ResponseBody
	@GetMapping("/customers")
	public String Customers() {
		List<Customer> customer = customerRepository.findAll();
		String result = "";
		for(Customer cust : customer){
			result += cust.toString() ;
		}
		return result;
	}
}
