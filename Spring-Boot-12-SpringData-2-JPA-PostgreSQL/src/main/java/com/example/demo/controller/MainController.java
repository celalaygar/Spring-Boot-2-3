package com.example.demo.controller;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CustomerRepository;

@RestController
public class MainController {

    @Autowired
    CustomerRepository customerRepository;
    
	@Autowired
	BookRepository bookRepository;
    
	
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		
		return "Hello World";
	}
	
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
}
