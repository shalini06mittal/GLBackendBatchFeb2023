package com.gl.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.boot.database.BookRepo;
import com.gl.boot.entity.Book;
import com.gl.boot.entity.Customer;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public List<Book> getBooksByAuthorId(int authorid)
	{
		List<Book> books = new ArrayList<>();
		 this.bookRepo.findByAuthorAid(authorid).forEach(books::add);
		 return books;
	}
}
