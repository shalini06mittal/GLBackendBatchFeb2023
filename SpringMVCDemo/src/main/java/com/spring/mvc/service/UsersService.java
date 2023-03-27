package com.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.database.UsersDatabase;
import com.spring.mvc.dto.LoginDTO;

@Service
public class UsersService {

	@Autowired
	private UsersDatabase database;
	
	public boolean validateUser(LoginDTO dto) throws Exception
	{
		if(this.database.loginUser(dto))
			return true;
		return false;
	}
}
