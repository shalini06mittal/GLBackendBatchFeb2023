package com.gl.boot.database;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gl.boot.entity.Book;
import com.gl.boot.entity.Customer;

public interface BookRepo extends CrudRepository<Book, Integer>{
	
	List<Book> findByAuthorAid(int aid);
	// custom query price > value and authorid =  ?
}
