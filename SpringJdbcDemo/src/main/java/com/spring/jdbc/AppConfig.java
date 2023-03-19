package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class AppConfig {

	/**
	 * following method provides with functionalities to communicate
	 * with database and open connection to database
	 * @return
	 */
	@Bean
	public DataSource dataSource()
	{
		System.out.println("creating data source");
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:8889/gl2023");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean
	@Autowired
	public JdbcTemplate template(DataSource source)
	{
		System.out.println("template craeted");
		return new JdbcTemplate(source);
	}
}
