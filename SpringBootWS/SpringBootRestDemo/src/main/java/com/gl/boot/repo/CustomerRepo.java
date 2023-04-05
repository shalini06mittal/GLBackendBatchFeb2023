package com.gl.boot.repo;

import org.springframework.data.repository.CrudRepository;

import com.gl.boot.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, String>{

}
