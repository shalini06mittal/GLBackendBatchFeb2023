package com.gl.boot.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gl.boot.entity.Customer;
import com.gl.boot.entity.CustomerView;

public interface CustomerRepo extends CrudRepository<Customer, String>{
	
	// select * from customers where city = ?
	List<Customer> findByCities(String city);
	List<Customer> findByCustnameLike(String name);
	List<Customer> findByCitiesAndCustnameLike(String city , String name);
	List<Customer> findByCitiesAndCustnameLikeOrCustnameLike(String city , String name1, String name2);
	
	// city
	@Query(nativeQuery = true, 
			value = "select * from customer where phone like :phone")
	List<Customer> getAllCustomersWhosePhoneStartswith(String phone);
	
	@Query(nativeQuery = true, 
			value = "select custname, phone from customer where phone like :phone")
	List<CustomerView> getAllCustomersViewWhosePhoneStartswith(String phone);
	
	// cities
	@Query(value = "select u from Customer u where phone like :phone")
	List<Customer> getAllCustomersWhosePhoneStartswithUseJPQL(String phone);
}
