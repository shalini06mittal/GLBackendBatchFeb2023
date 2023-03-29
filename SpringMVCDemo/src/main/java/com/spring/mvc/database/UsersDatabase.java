package com.spring.mvc.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.LoginDTO;
import com.spring.mvc.entity.Users;

@Repository
public class UsersDatabase {

	@Autowired
	private SessionFactory factory;
	
	public List<Users> getAllUsers()
	{
		Session session = factory.openSession();
		List<Users> users = session.createQuery("from Users", Users.class).getResultList();
		session.close();
		return users;
	}
	public boolean loginUser(LoginDTO dto) throws Exception
	{
		System.out.println(dto);
		Session session = factory.openSession();
		Users user = session.get(Users.class, dto.getEmail());
		System.out.println(user);
		if(user != null)
		{
			if(dto.getPassword().equals(user.getPassword()))
				return true;
		}
		throw new Exception("Invalid Credentials");
	}
}
