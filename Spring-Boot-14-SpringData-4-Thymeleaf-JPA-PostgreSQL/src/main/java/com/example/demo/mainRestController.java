package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerRoles;
import com.example.demo.entity.Role;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.CustomerRolesRepository;
import com.example.demo.repository.RoleRepository;

@RestController
@RequestMapping("/rest")
public class mainRestController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RoleRepository roleRepository;
		
	@Autowired
	CustomerRolesRepository customerRolesRepository;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert() {
		Customer c1=new Customer("Fatih@ggmc.com", "Fatih Seyram gürsoy", "Seyram333", true);
		Customer c2=new Customer("kahraman.bilal@ggmc.com", "Bilal Fatih kahraman", "kahraman222", true);
		Customer c3=new Customer("mestan.nurullah@ggmc.com", "Nurullah mestan aksoy", "mestan123", true);
		Customer c4=new Customer("nuran.ayca@ggmc.com", "Ayçameryem nuran", "nuran.meryem", true);
		
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		customerRepository.save(c4);
		System.out.println("--------------------------------------");
		
		CustomerRoles role1=new CustomerRoles("ADMIN_ADMIN", c1);
		CustomerRoles role2=new CustomerRoles("ADMIN_USER", c1);
		CustomerRoles role3=new CustomerRoles("ADMIN_EDITOR", c1);
		CustomerRoles role4=new CustomerRoles("ADMIN_WRİTER", c3);
		CustomerRoles role5=new CustomerRoles("ADMIN_EDITOR", c3);
		CustomerRoles role6=new CustomerRoles("ADMIN_USER", c3);
		CustomerRoles role7=new CustomerRoles("ADMIN_USER", c4);

//		customerRolesRepository.saveAll(Arrays.asList(role1,role2,role3,role4,role5,role6,role7));
		customerRolesRepository.save(role1);
		customerRolesRepository.save(role2);
		customerRolesRepository.save(role3);
		customerRolesRepository.save(role4);
		customerRolesRepository.save(role5);
		customerRolesRepository.save(role6);
		customerRolesRepository.save(role7);
		System.out.println("--------------------------------------");
	
		return "insert Data..................";
	}
	@ResponseBody
	@RequestMapping("/customers")
	public List<Customer> customers() {
		List<Customer> liste= (List<Customer>) customerRepository.findAll();
		return liste;
	}
	
	@RequestMapping("/cust")
	public String custs() {
		List<Customer> liste= (List<Customer>) customerRepository.findAll();
		String result="";
		for (Customer customer : liste) {
			result+=customer.toString();
		}
		return result;
	}
}
