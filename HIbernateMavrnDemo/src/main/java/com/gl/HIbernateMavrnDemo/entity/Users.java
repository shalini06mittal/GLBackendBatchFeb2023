package com.gl.HIbernateMavrnDemo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	@Column(length = 150)
	private String email;
	@Column(length = 30)
	private String password;
	
	private LocalDate date_created;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDate_created() {
		return date_created;
	}
	public void setDate_created(LocalDate date_created) {
		this.date_created = date_created;
	}
	
	
}
