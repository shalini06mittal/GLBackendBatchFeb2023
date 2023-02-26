package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDBConnection {

	Connection conn = DBConnection.getConnection();

	public List<Customer> getAllCustomers()
	{
		String sql = "select * from customer";
		/**
		 * 1. get DB connection
		 */
		//2. create statements
		List<Customer> customers = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				Customer c1 = new Customer();
				c1.setEmail(rs.getString(1));
				c1.setCustname(rs.getString(2));
				c1.setCity(rs.getString(3));
				c1.setPhone(rs.getString(4));
				c1.setPassword(rs.getString(5));
				customers.add(c1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	public boolean insertCustomer(Customer customer) throws Exception
	{

		return true;
	}
	public Customer getCustomerByEmail(String email)
	{
		Customer customer = null;


		return customer;
	}
	public boolean updateCustomer(Customer customer) throws Exception
	{

		return true;
	}
	public boolean deleteCustomer(String email) throws Exception
	{

		return true;
	}
	public boolean login(String email, String password)
	{

		return false;
	}
}
