package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//	  @Query("SELECT b FROM book b WHERE b.customerid = :customerid")
	Book findByName(String name);
	
}
