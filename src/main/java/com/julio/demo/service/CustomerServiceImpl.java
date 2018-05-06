package com.julio.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.demo.entity.Customer;
import com.julio.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}


	@Override
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		
		return customerRepository.findByLastName(lastName);
	}

	
	@Override
	public Customer findById(String id)
	{
		Customer result = customerRepository.findById(id).orElse(null);
		
		return result;
	}
	
	
	
}
