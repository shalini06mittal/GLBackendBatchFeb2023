package com.gl.boot.database;

import org.springframework.data.repository.CrudRepository;

import com.gl.boot.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, String>{
}
