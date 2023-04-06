package com.gl.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// bean or pojo or model or entity class
// FYI - lombok, loggers

@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@Table(name="customer")
public class Customer {

	@Id

	private String email;

	private String custname;
	
	@Column(name="city")
	private String cities;

	private String phone;
	private String password;

}
