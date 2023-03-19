package com.spring.jdbc.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// bean or pojo or model or entity class
// FYI - lombok, loggers

@NoArgsConstructor
@Data
public class Customer {

	private String email;
	private String custname;
	private String city;
	private String phone;
	private String password;

}
