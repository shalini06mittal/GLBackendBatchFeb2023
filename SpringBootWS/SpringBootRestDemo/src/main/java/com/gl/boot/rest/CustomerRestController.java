package com.gl.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.boot.entity.Customer;
import com.gl.boot.service.CustomerService;

// RESt URI -> identifier a resource
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService service;
	
	@GetMapping
	public List<Customer> getAllCustomers()
	{
		// req to an API
		return service.getAllCustomers();
	}
	@GetMapping("/city/{city}")
	public List<Customer> getAllCustomers(@PathVariable String city)
	{
		// req to an API
		return service.getAllCustomersByCity(city);
	}
	@GetMapping("/{email}")
	public Customer getCustomerByEmail(@PathVariable String email)
	{
		return service.getCustomerById(email);
	}
}
