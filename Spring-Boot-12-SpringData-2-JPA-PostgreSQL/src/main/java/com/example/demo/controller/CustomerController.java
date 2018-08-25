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
	
	@Autowired
	BookRepository bookRepository;

	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert() {
		Customer c1=new Customer("Emrah" , "emrah@gmail.com");
		Customer c2=new Customer("Ayla" , "ayla@gmail.com");
		Customer c3=new Customer("Ebru Nur" , "ebrunur@gmail.com");
		Book b1=new Book("Ankara Hayatı",c1);
		Book b2=new Book("Kahve Köşesi",c1);
		Book b3=new Book("Memleket İnsani",c2);
		Book b4=new Book("Temel ile Dursun",c2);
		
		Book b5=new Book("Seyahat yolunda Tom and Jery",c3);
		
		c1.setBooks(new HashSet<Book>() {{
			add(b1);
			add(b2);
		}});
		c2.setBooks(new HashSet<Book>() {{
			add(b3);
			add(b4);
		}});
		c3.setBooks(new HashSet<Book>() {{
			add(b5);
		}});
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);
		
		//--------------------------------------------------
		
		Customer c4=new Customer("Kubilay" , "kubilay@gmail.com");
		Customer c5=new Customer("Ela" , "ela@gmail.com");
		customerRepository.save(c4);
		customerRepository.save(c5);
		
		Book b6=new Book("Beyaz Hikaye",c4);
		Book b7=new Book("Kalp Ağrısı",c4);
		Book b8=new Book("Sarı Gül",c5);
		Book b9=new Book("Papatya Misali",c5);
		Book b10=new Book("Gonca Mevsimi",c5);
		Book b11=new Book("Kara Kış",c5);
		bookRepository.saveAll(Arrays.asList(b6,b7,b8,b9,b10,b11));
		
		return "insert Data..................";
	}
	
	
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
