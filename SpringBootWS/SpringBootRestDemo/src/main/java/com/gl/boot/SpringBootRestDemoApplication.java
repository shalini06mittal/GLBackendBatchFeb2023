package com.gl.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gl.boot.entity.Customer;
import com.gl.boot.repo.CustomerRepo;
import com.gl.boot.service.CustomerService;

@SpringBootApplication
public class SpringBootRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDemoApplication.class, args);
	}
	
	@Autowired
	private CustomerService customerService;
	
	@Bean
	void setCustomerData()
	{
		Customer c1 = new Customer("a@a.c", "AA", "Mumbai", "1212121212", "aa");
		Customer c2 = new Customer("b@a.c", "BB", "Pune", "1212121212", "bb");
		Customer c3 = new Customer("c@a.c", "CC", "Mumbai", "1212121212", "cc");
		Customer c4 = new Customer("d@a.c", "DD", "Delhi", "1212121212", "dd");
		
		customerService.insertCustomer(c1);
		customerService.insertCustomer(c2);
		customerService.insertCustomer(c3);
		customerService.insertCustomer(c4);
		
	}
	
	
	
}
