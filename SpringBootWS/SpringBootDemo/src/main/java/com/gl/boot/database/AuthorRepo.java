package com.gl.boot.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gl.boot.entity.Author;
import com.gl.boot.entity.Customer;

public interface AuthorRepo extends CrudRepository<Author, Integer>{
	
	
}
