package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repo.BookRepository;
import com.example.demo.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    public CustomerService(CustomerRepository customerRepository, BookRepository bookRepository) {
        this.customerRepository = customerRepository;
        this.bookRepository = bookRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void updateBookTitle(Long bookId, String title) {
        bookRepository.updateBookTitle(bookId, title);
    }
}
