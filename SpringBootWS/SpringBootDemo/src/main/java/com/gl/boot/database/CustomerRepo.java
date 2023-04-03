package com.gl.boot.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gl.boot.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, String>{
	
	// select * from customers where city = ?
	List<Customer> findByCities(String city);
	List<Customer> findByCustnameLike(String name);
	List<Customer> findByCitiesAndCustnameLike(String city , String name);
	List<Customer> findByCitiesAndCustnameLikeOrCustnameLike(String city , String name1, String name2);
}
