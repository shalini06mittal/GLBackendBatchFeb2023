package com.gl.boot.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gl.boot.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, String>{
	List<Customer> findByCities(String city);
}
