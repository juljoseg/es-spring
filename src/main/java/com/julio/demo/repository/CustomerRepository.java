package com.julio.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.julio.demo.entity.Customer;


public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

	    List<Customer> findByLastName(String lastName);

	  
	 
	
}
