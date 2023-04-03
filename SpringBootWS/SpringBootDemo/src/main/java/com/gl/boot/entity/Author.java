package com.gl.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// author is a database managed entity
@Entity
@Table(name = "author") // optional
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authorid")
	private int aid;
	@Column(name="authorname", length = 120, nullable = false)
	private String name;
	private String genre;
	@Column(nullable = true)
	private int year;
//	@OneToOne(mappedBy = "author")
//	Book book;
	
	
}

