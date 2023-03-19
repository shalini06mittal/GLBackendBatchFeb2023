package com.spring.jdbc.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDB {

	@Autowired
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}
	
	public long getCustomerCount()
	{
		String sql = "select count(*) from customer";
		return template.queryForObject(sql, Long.class);
	}
	
}
