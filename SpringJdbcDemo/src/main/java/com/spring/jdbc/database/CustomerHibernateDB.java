package com.spring.jdbc.database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.jdbc.entity.Customer;

@Repository
public class CustomerHibernateDB {

	@Autowired
	private SessionFactory factory;

	
	
	public CustomerHibernateDB(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public long getCustomerCount()
	{
		String sql = "select count(*) from customer";
		return 0L;
	}
	
	public boolean insertCustomer(Customer customer) throws Exception
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		return true;
	}
//	public boolean deleteCustomer(String email) throws Exception
//	{
//		String sql = "delete from customer where email =?";
//		try {
//			template.update(sql, email);
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//			//return false;
//			throw new Exception(e.getMessage());
//		}
//		 
//		 return true;
//	}
//	public boolean updateCustomer(Customer customer) throws Exception
//	{
//		String sql = "update customer set custname=?, city=?, phone=? where email=?";
//		try {
//			template.update(sql, customer.getCustname()
//					, customer.getCity(), customer.getPhone(), customer.getEmail());
//		}
//		catch (Exception e)
//		{
//			System.out.println(e.getMessage());
//			//return false;
//			throw new Exception(e.getMessage());
//		}
//		 
//		 return true;
//	}
//	public Customer getCustomerByEmail(String email)
//	{
//		String sql = "select * from customer where email=?";
//		return template.queryForObject(sql, new CustomerRowMapper(), email);
//	}
//	
//	public List<Customer> getCustomers()
//	{
//		String sql = "select * from customer";
//		return template.query(sql, new CustomerRowMapper());
//	}
//	
//	class CustomerRowMapper implements RowMapper<Customer>{
//
//		@Override
//		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//			// TODO Auto-generated method stub
//			Customer customer = new Customer();
//			customer.setEmail(rs.getString(1));
//			customer.setCustname(rs.getString(2));
//			customer.setCity(rs.getString(3));
//			customer.setPhone(rs.getString(4));
//			customer.setPassword(rs.getString(5));
//			return customer;
//		}
//		
//	}
	
}
