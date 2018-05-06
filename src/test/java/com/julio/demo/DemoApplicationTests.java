package com.julio.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.julio.demo.entity.Customer;
import com.julio.demo.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	private CustomerService customerService;
	
	
	
	@Test
	public void testSave()
	{
		Customer customer = new Customer("1", "LastName1", "FirstName1");
		
		Customer customerSaved =  customerService.save(customer);
		
		assertNotNull(customer);
		assertEquals(customerSaved.getCustomerId(),customer.getCustomerId());
		assertEquals(customerSaved.getLastName(),customer.getLastName());
		assertEquals(customerSaved.getFirstName(),customer.getFirstName());
		
	}

	
	 @Test
    public void testFindOne() {

	 customerService.save(new Customer("1", "FirstName1","LastName1"));
	  
	 List<Customer> result = customerService.findByLastName("LastName1");
     
     assertNotNull(result);
     assertNotNull(result.get(0));
     assertThat(result.size()).isEqualTo(1);

    }
	 
	 
	 @Test
	 public void testDelete()
	 {
		 Customer customer = new Customer("1", "LastName1", "FirstName1");
		  
		 customerService.save(customer);
		 
		 customerService.delete(customer);
		 
		 List<Customer> result = customerService.findByLastName("LastName1");
		 
		 assertThat(result.size()).isEqualTo(0);
		 
	 }
	 
	 
	
}

