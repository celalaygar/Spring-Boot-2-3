package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {
	 void saveCustomer(Customer customer);
	 public List<Customer> findallCustomers();
	 Customer findCustomerById(Long id);
	 void DeleteCustomerById(Long id);
	 void UpdatedCustomer(Long id, Customer customer);
	 
	 
}
