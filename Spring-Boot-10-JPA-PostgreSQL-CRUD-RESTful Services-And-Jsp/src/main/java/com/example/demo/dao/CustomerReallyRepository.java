package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerReallyRepository {

	void save(Customer customer);
	List<Customer> findallCustomers();
}
