package com.gl.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

// bean or pojo or model or entity class
// FYI - lombok, loggers

@NoArgsConstructor
@Data
@Entity
public class Customer {

	@Id
	private String email;
	private String custname;
	@Column(name="city")
	private String cities;
	private String phone;
	private String password;

}
