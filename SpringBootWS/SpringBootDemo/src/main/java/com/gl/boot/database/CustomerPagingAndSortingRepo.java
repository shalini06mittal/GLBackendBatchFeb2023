package com.gl.boot.database;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.gl.boot.entity.Customer;

public interface CustomerPagingAndSortingRepo extends PagingAndSortingRepository<Customer, String>{
	
}
	
	
