package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerRoles;
import com.example.demo.entity.Role;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.CustomerRolesRepository;

@RestController
@RequestMapping("/rest")
public class mainRestController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerRolesRepository customerRolesRepository;

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

	
	@RequestMapping("/customers")
	public List<Customer> customers() {
		List<Customer> liste = (List<Customer>) customerRepository.findAll();
		return liste;
	}
	@RequestMapping("/customer/{email}")
	public Customer customerByemail(@PathVariable String email) {
		Customer customer = customerRepository.findCustomerDataByemail(email);
		return customer;
	}

	@RequestMapping("/cust")
	public String custs() {
		List<Customer> liste = (List<Customer>) customerRepository.findAll();
		String result = "";
		for (Customer customer : liste) {
			result += customer.toString();
		}
		return result;
	}
}
