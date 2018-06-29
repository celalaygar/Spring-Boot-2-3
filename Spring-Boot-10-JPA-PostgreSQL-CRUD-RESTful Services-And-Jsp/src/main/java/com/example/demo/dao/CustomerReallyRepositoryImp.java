package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public class CustomerReallyRepositoryImp implements CustomerReallyRepository {

    @Autowired
    private EntityManager entityManager;
    
    
	@Override
	public void save(Customer customer) {
		entityManager.persist(customer);
	}

	public List<Customer> findallCustomers(){
		
		String sql="from customer";
		return entityManager.createQuery(sql,Customer.class).getResultList();
	}
}
