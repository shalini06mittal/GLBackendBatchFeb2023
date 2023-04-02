package com.gl.boot.entity;

//import javax.persistence.Entity;
//import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// bean or pojo or model or entity class
// FYI - lombok, loggers

@NoArgsConstructor
@Data
//@Entity
public class Customer {

//	@Id
	private String email;
	private String custname;
	private String city;
	private String phone;
	private String password;

}
