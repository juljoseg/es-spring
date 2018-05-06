package com.julio.demo.service;

import com.julio.demo.entity.Customer;

import java.util.List;


public interface CustomerService {

	Customer save(Customer customer);

    void delete(Customer customer);

    Iterable<Customer> findAll();

    List<Customer> findByLastName(String lastName);

    public Customer findById(String id);

	
}
