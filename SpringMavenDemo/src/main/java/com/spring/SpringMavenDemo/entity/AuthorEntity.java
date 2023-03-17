package com.spring.SpringMavenDemo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("author")
public class AuthorEntity {

	//field injection
	@Value("111")
	private int aid;
	@Value("Pranay")
	private String aname;
	@Value("suspense")
	private String genre;
	
	public AuthorEntity() {
		System.out.println("Author default constructor");
	}

	// constructor injection
	public AuthorEntity( @Value("111")int aid, 
			@Value("Pranay")String aname, 
			@Value("adv")String genre) {
		System.out.println("Author parameterized constructor");
		this.aid = aid;
		this.aname = aname;
		this.genre = genre;
	}
//	public AuthorEntity(int aid, 
//			String aname, 
//			String genre) {
//		System.out.println("Author parameterized constructor");
//		this.aid = aid;
//		this.aname = aname;
//		this.genre = genre;
//	}

	public int getAid() {
		return aid;
	}

	
	public void setAid(int id) {
		System.out.println("set author id");
		this.aid = id;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getGenre() {
		return genre;
	}

	//@Value("Pranay")
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", aname=" + aname + ", genre=" + genre + "]";
	}
	
}
