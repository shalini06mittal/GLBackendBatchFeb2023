package com.gl.boot.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// author is a database managed entity
@Entity
@Table(name = "author_m2m") // optional
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthorManyToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorid")
	private int aid;
	private String name;
	private String genre;
	private int year;
	@ManyToMany
	@JoinTable(name="author_books", 
	joinColumns = @JoinColumn(name="authorid"),
	inverseJoinColumns = @JoinColumn(name="bookid")
			)
	private List<Book> books;
	
	
	
}

