package com.gl.boot.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gl.boot.dto.ResponseDTO;
import com.gl.boot.entity.Customer;
import com.gl.boot.service.CustomerService;

// RESt URI -> identifier a resource
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService service;

	/**
	 * 
	 * @return list + string
	 */

	@GetMapping
	public ResponseEntity<ResponseDTO> getAllCustomers()
	{
		// req to an API
		List<Customer> customers = service.getAllCustomers();
		return ResponseEntity.ok(new ResponseDTO("SUCCESS", customers));
	}
	// http://localhost/city/Mumbai => path variable
	// http://localhost?city=Mumbai => request param
	// producer
	@GetMapping(path = "/city/{city}", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Customer> getAllCustomers(@PathVariable String city)
	{
		// req to an API
		return service.getAllCustomersByCity(city);
	}
	@GetMapping("/{email}")
	public ResponseEntity<Object> getCustomerByEmail(@PathVariable String email)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			Customer customer = service.getCustomerById(email);
			map.put("customer", customer);
			return ResponseEntity
					.status(HttpStatus.FOUND)
					.body(map);
		}catch(EntityNotFoundException e)
		{
			map.put("message", e.getMessage());
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(map);
		}
	}
	// accept , produces or consumes
	//	@PostMapping
	//	public String insertCustomer(@RequestBody String customer)
	//	{
	//		System.out.println(customer);
	//	
	////		System.out.println(state);
	////		Customer c= this.service.insertCustomer(customer);
	//		return "Customer registered";
	//	}
	@PostMapping
	public  ResponseEntity<ResponseDTO> insertCustomer(@RequestBody Customer customer)
	{
		System.out.println(customer);
		try {
			Customer c= this.service.insertCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseDTO("SUCCESS", c));
		}catch(EntityExistsException e)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new ResponseDTO("FAILURE", e.getMessage()));
		}
	}
	@PutMapping
	public String updateCustomer(@RequestBody Customer customer)
	{

		return "Customer updated";
	}
	@DeleteMapping
	public String deleteCustomer()
	{
		return "Customer deleted";
	}

}
