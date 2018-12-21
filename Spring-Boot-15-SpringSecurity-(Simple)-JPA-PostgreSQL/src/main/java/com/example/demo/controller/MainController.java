package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		List<Customer> customers = (List<Customer>) customerRepository.findAll();

		model.put("message", this.message);
		model.put("customers", customers);
		return "customers";
	}

	@ResponseBody
	@RequestMapping("/customer/{email}")
	public String customerByemail(@PathVariable String email) {
		Customer customer = customerRepository.findCustomerDataByemail(email);
		String getCustomer="id : "+customer.getId()+" <br/> ";
		getCustomer+="name : "+customer.getName()+" <br/> ";
		getCustomer+="email : "+customer.getEmail()+"<br/> ";
		getCustomer+="password : "+customer.getPassword()+" <br/> ";
		return getCustomer;
	}


	@RequestMapping("/insert")
	@ResponseBody
	public String insert() {
		Customer c1 = new Customer("FatihTerim@hotmail.com", "Fatih Terim", "Fatih34", true);
		Customer c2 = new Customer("kahraman.Yalçın@gmail.com", "Yalçın kahraman", "kahraman06", true);
		Customer c3 = new Customer("Kebapçı.Husnu@gmail.com", "Kebapçı Hüsnü", "Hüsnü123", true);
		Customer c4 = new Customer("Ayça.ilgi@mynet.com", "Ayça İlgi Bilem", "ilgi-bilem", true);
		Customer c5 = new Customer("Ayşe.ilgisiz@hotmail.com", "Ayşe ilgisiz", "00ilgisiz", true);
		Customer c6 = new Customer("Sila.Kanat@mynet.com", "Sıla Kanata", "Sila-Ka", true);
		Customer c7 = new Customer("Arda.Turan@hotmail.com", "Arda Turan", "Arda-GS", true);

		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
		customerRepository.save(c5);
		customerRepository.save(c6);
		customerRepository.save(c7);

		CustomerRoles role1 = new CustomerRoles("ADMIN_ADMIN", c1);
		CustomerRoles role2 = new CustomerRoles("ADMIN_USER", c1);
		CustomerRoles role3 = new CustomerRoles("ADMIN_EDITOR", c1);
		CustomerRoles role4 = new CustomerRoles("ADMIN_WRİTER", c3);
		CustomerRoles role5 = new CustomerRoles("ADMIN_EDITOR", c2);
		CustomerRoles role6 = new CustomerRoles("ADMIN_USER", c3);
		CustomerRoles role7 = new CustomerRoles("ADMIN_USER", c4);
		CustomerRoles role8 = new CustomerRoles("ADMIN_ADMIN", c5);
		CustomerRoles role9 = new CustomerRoles("ADMIN_WRİTER", c5);
		CustomerRoles role10 = new CustomerRoles("ADMIN_EDITOR", c6);
		CustomerRoles role11 = new CustomerRoles("ADMIN_USER", c7);
		CustomerRoles role12 = new CustomerRoles("ADMIN_EDITOR", c7);

		// how to use save all roles of customers
		customerRolesRepository.saveAll(
				Arrays.asList(role1, role2, role3, role4, role5, role6, role7, role8, role9, role10, role11, role12));

		return "insert Data..................";
	}

	
	@RequestMapping("/userinfo")
	public String userinfo(Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.put("message", "User details");
		model.put("user", auth.getName());  
		model.put("role", auth.getAuthorities());
		return "userinfo";
	}

}
