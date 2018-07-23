package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CustomerCrudRepository;
import com.example.demo.dao.CustomerJpaRepository;
import com.example.demo.dao.CustomerReallyRepository;
import com.example.demo.model.Customer;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	public CustomerReallyRepository CustomerReallyRepository;

	@Autowired
	CustomerJpaRepository customerJpaRepository;

	@Override
	public void saveCustomer(Customer customer) {
		//CustomerReallyRepository.save(customer);
		customerJpaRepository.save(customer);
	}

	@Override
	public List<Customer> findallCustomers() {
		//return CustomerReallyRepository.findallCustomers();
		return customerJpaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));

	}

	public void DeleteCustomerById(Long id) {
		customerJpaRepository.deleteById(id);
	}
	
	public void UpdatedCustomer(Long id, Customer customer) {
		Optional<Customer> optionalCustomer= customerJpaRepository.findById(id);
		customer.setId(id);
		customerJpaRepository.save(customer);
	}
	
	@Override
	public Customer findCustomerById(Long id) {
		return customerJpaRepository.findById(id).get();
	}
}
