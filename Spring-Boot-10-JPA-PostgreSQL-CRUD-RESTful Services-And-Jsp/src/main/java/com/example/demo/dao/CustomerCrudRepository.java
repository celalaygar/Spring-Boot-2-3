package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
@Repository
public interface CustomerCrudRepository extends CrudRepository<Customer, Long> {

	
}
