package com.gl.boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.boot.entity.Customer;
import com.gl.boot.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo cRepo;
	

	public long getCustomerCount()
	{
		return this.cRepo.count();
	}
	public Customer insertCustomer(Customer customer)
	{
		if(this.cRepo.existsById(customer.getEmail()))
			throw new EntityExistsException("cutomer with "+customer.getEmail()+" already exists");
		return this.cRepo.save(customer);
	}
	public Customer updateCustomer(Customer customer)
	{
		if(! this.cRepo.existsById(customer.getEmail()))
			throw new EntityNotFoundException("cutomer with "+customer.getEmail()+" does not exists, cannot update");
		return this.cRepo.save(customer);
	}
	public void deleteCustomer(String email)
	{
		if(! this.cRepo.existsById(email))
			throw new EntityNotFoundException("cutomer with "+email+" does not exist, cannot delete");
		this.cRepo.deleteById(email);;
	}
	public Customer getCustomerById(String email)
	{
		return this.cRepo.findById(email)
				.orElseThrow(()-> new EntityNotFoundException("cutomer with "+email+" does not exist"));
	}
	public List<Customer> getAllCustomers()
	{
		List<Customer> customers = new ArrayList<>();
		 this.cRepo.findAll().forEach(customers::add);
		 return customers;
	}
	
	public List<Customer> getAllCustomersByCity(String city)
	{
		List<Customer> customers = new ArrayList<>();
		 this.cRepo.findByCities(city).forEach(customers::add);
		 return customers;
	}
	
	
	
}
