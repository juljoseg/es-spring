package com.julio.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "demo", type = "customers")
public class Customer {

	@Id
    private String customerId;
    private String firstName;
    private String lastName;
    
    @JsonCreator
	public Customer(@JsonProperty("customerId") String id, 
			@JsonProperty("firstName")String firstName, 
			@JsonProperty("lastName")String lastName) {
		super();
		this.customerId = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}



    
    
}
