package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookServices {
	@Autowired
	BookRepository bookRepository;
//	
//	public List<Book> findBooksByCustomerid(Long customer_id) {
//		
//		return bookRepository.findByCustomerid(customer_id); 
//	}
	
}
