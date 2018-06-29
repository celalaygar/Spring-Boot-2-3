package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.CustomerServiceImp;
import com.example.demo.dao.CustomerCrudRepository;

@RestController
public class HomeController {
	
	 
	@Autowired
	CustomerCrudRepository repository;
	 
	
	@Autowired
	CustomerService customerService;
	
	//index jsp
	@GetMapping("/")
	public ModelAndView getHome() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		mav.addObject("message", "this is an index jsp file called index.jsp");
		return mav;
	}

	
	//insert data
	@PostMapping("/InsertCustomer")
	public ModelAndView InsertCustomer(@Valid @ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return StaticCustomersFile("customers","İnsert Customer");	
	}
	
	//view insert form on jsp
	@GetMapping("/insertCustomerPanel")
	public ModelAndView insertCustomerPanel() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("title", " - Customers İnsert Panel - ");
		mav.addObject("message", "this is an customer İnsert Panel");
		mav.addObject("customer", new Customer());
		mav.setViewName("insertCustomer");
		return mav;
	}
	
	//update data
	@PostMapping("/UpdateCustomer")
	public ModelAndView UpdateCustomer(@Valid @ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return StaticCustomersFile("customers","Update Customer");	
	}
	
	
	//view update form on jsp
	@GetMapping("/updateCustomerPanel/{id}")
	public ModelAndView updateCustomerPanel(@PathVariable("id") long id) {

		Customer customer=customerService.findCustomerById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("title", " - Customers Update Panel - ");
		mav.addObject("message", "this is an customer Update Panel");
		mav.addObject("customer", customer);
		mav.setViewName("updateCustomer");
		return mav;
	}
	

	//select all data
	@GetMapping("/customers")
	public ModelAndView getCustomersPage() {
		List<Customer> customers=customerService.findallCustomers();
		ModelAndView mav=new ModelAndView();
		mav.addObject("title", "Customers File");
		mav.addObject("customers",customers);
		mav.addObject("message", "this is an customer jsp file called customers.jsp");
		mav.setViewName("customers");
		return mav;
	}
	
	
	//select single data on jps
	@GetMapping("/viewCustomer/{id}")
	public ModelAndView viewCustomer(@PathVariable("id") long id){

		Customer customer=customerService.findCustomerById(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("viewCustomer");
		mav.addObject("title", "Hoşgeldiniz "+customer.firstName+" "+customer.lastName);
		mav.addObject("customer", customer);

		mav.addObject("message", "Details of Customer");
		return mav;
	}
	
	//delete data on jps
	@GetMapping("/deleteCustomer/{id}")
	public ModelAndView deleteCustomer(@PathVariable("id") long id){
		customerService.DeleteCustomerById(id);
		//ModelAndView mav=new ModelAndView("redirect:/customers");
		return StaticCustomersFile("customers","delete data");
	}
	
	//save multiple sample Customers
	@GetMapping("/saveAll")
	public ModelAndView SaveAll(){
		//save a single Customer
		customerService.saveCustomer(new Customer("Jack", "Watsenn"));
		
		//save a list of Customers
		repository.saveAll(Arrays.asList(new Customer("Muharrem", "İnce"),new Customer("Fatih", "Yardımcı"),
				new Customer("Fatih", "Terim"),new Customer("Celal", "Aygar"),
				new Customer("Adem", "Yılmaz"), new Customer("Kim Kissle", "Kardishian"),
				new Customer("David", "Backhem"), new Customer("Peter Hard", "John")));

		return StaticCustomersFile("customers","İnsert multiple sample Customers");
	}
	
	
	public ModelAndView StaticCustomersFile(String viewname,String message) {
		List<Customer> customers=customerService.findallCustomers() ;
		ModelAndView mav=new ModelAndView();
		mav.addObject("title", "Customers File");
		mav.addObject("customers",customers);
		mav.addObject("message", message);
		mav.setViewName(viewname);
		return mav;
	}
	
	
}
