package com.julio.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.julio.demo.entity.Customer;
import com.julio.demo.service.CustomerService;

@Controller
public class CustomerWebController {

	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		return "customer";
	}

	private List<Customer> customerList = new ArrayList<>();
	
	@PostMapping("/create")
	public String createCustomer(@RequestParam("firstName") String firstName,
								@RequestParam("lastName") String lastName,
								@RequestParam("customerId") String customerId,
								Model model) 
	{
		Customer customer = new Customer(customerId, firstName, lastName);
		
		customerService.save(customer);

		//List all cust
				
		listCust();
		
		model.addAttribute("customerList",this.customerList );
		
		return "customer";
	}
	
	
	@PostMapping("/delete")
	public String updateCustomer(@RequestParam("selectedValue") String selectedValue,
								Model model) 
	{
		Customer customer = customerService.findById(selectedValue);
		
		customerService.delete(customer);
		
		listCust();
		
		model.addAttribute("customerList",this.customerList );
		
		return "customer";
	}
	
	
	@PostMapping("/find")
	public String findCustomer(@RequestParam("customerId") String customerId,
								Model model) 
	{
		Customer customer = customerService.findById(customerId);
		
		listCust();
		
		model.addAttribute("customerList",this.customerList );
		model.addAttribute("customer",customer );
		
		return "customer";
	}
	
	
	private void listCust() {
		//List all cust
		
		this.customerList.clear();
		
		customerService.findAll().forEach(System.out::println);
		
		customerService.findAll().forEach(c -> this.customerList.add(c));
				
		
	}

}
