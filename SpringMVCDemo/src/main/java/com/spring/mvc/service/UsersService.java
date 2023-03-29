package com.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.database.UsersDatabase;
import com.spring.mvc.dto.LoginDTO;
import com.spring.mvc.entity.Users;

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
	public List<String> getAllUsersEmail()
	{
		List<Users> users = this.database.getAllUsers();
		List<String> useremail = new ArrayList<String>();
		users.forEach(user -> useremail.add(user.getEmail()));
		return useremail;
				
	}
}
