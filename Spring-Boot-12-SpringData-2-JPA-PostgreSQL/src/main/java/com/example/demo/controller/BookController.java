package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookServices;

@RestController
public final class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookServices bookServices;
	
	@ResponseBody
	@GetMapping("/books")
	public String Customers() {
		List<Book> book = bookRepository.findAll();
		String result = "";
		for(Book b : book){
			result += b.toString() + "<br>";
		}
		return result;
	}
	@ResponseBody
	@GetMapping("/books/{customer_id}")
	public String booksByCustomer_id(@PathVariable("customer_id") Long id) {
		List<Book> book = bookRepository.findAll();
		String result = id+"<br> ";
		for(Book b : book){
			result += b.toString() + "<br>";
		}
		return result;
	}
	@ResponseBody
	@GetMapping("/book/{id}")
	public String booksByid(@PathVariable("id") Long id) {
		Optional<Book> book = bookRepository.findById(id);

		return book.get().toString2();
	}
	
	@ResponseBody
	@GetMapping("/book_name/{name}")
	public String booksByName(@PathVariable("name") String name) {
		Book book = bookRepository.findByName(name);

		return book.toString2();
	}
}
