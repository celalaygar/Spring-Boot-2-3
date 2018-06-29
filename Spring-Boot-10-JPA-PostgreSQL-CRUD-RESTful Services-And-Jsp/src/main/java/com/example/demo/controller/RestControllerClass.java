package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerCrudRepository;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/rest")
public class RestControllerClass {
	@Autowired
	CustomerCrudRepository repository;
	
	@Autowired
	CustomerService customerService;

	//select sıngle data
	//http://localhost:8182/rest/Customer/id
	@GetMapping(value="/Customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
		Customer customers=customerService.findCustomerById(id);
		System.out.println("-------------------------------------------------------------------------------------------------");
		System.out.println(customers.id+" : "+customers.firstName+" "+customers.lastName);
		return ResponseEntity.ok(customers);
	}

	//delete single data
	//http://localhost:8182/rest/DeleteCustomer/id
	@DeleteMapping(value="/DeleteCustomer/{id}")
	public String DeleteCustomer(@PathVariable("id") Long id){
		customerService.DeleteCustomerById(id);
		return "Removed Data";
	}
	
	//http://localhost:8182/rest/DeleteCustomer/id
	@PutMapping(value="/UpdateCustomer/{id}")
	public ResponseEntity<Customer> UpdateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
		
		/*Customer customer1=new Customer();
		customer1.setId(id);
		customer1.setFirstName("Sarp");
		customer1.setLastName("Yılmaz");
		*/
		customerService.UpdatedCustomer(id, customer);
		return ResponseEntity.noContent().build();
	}
	
	
	//select all data
	//http://localhost:8182/rest/findall
	@GetMapping(value="/Customers")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> customers=customerService.findallCustomers() ;

		return ResponseEntity.ok(customers);
	}
	
	//multiple sample data
	@RequestMapping("/save")
	public String process(){
		// save a single Customer
		customerService.saveCustomer(new Customer("Jack", "Watsenn"));
		
		// save a list of Customers
		repository.saveAll(Arrays.asList(new Customer("Muharrem", "İnce"),
				new Customer("Fatih", "Yardımcı"),new Customer("Fatih", "Terim"),
				new Customer("Celal", "Aygar"),new Customer("Adem", "Yılmaz"), 
				new Customer("Kim Kissle", "Kardishian"), new Customer("David", "Backhem"), 
				new Customer("Peter Hard", "John"), new Customer("George", "Bush")));
		return "Done";
	}
	
	
	
	/*
	@RequestMapping(value="/findall",produces= {"application/json","application/xml"})
	public String findAll(){
		String result = "";
		
		for(Customer cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}
		
		return result;
	}
	*/

}