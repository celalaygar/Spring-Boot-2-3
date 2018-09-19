package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Secured("USER")
	@Query("select c from Customer c Where c.email= :email")
	Customer findCustomerDataByemail(@Param("email") String email);
}
