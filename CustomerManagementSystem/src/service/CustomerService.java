package service;

import java.util.List;

import database.CustomerDBConnection;
import database.CustomerDatabase;
import model.Customer;

public class CustomerService {

	//private CustomerDatabase customerDatabase ;
	private CustomerDBConnection customerDatabase ;

//	public CustomerService(CustomerDatabase customerDatabase) {
//		// TODO Auto-generated constructor stub
//		this.customerDatabase = customerDatabase;
//	}
	public CustomerService(CustomerDBConnection customerDatabase) {
		// TODO Auto-generated constructor stub
		this.customerDatabase = customerDatabase;
	}
	public List<Customer> getAllCustomers() throws Exception
	{
		if(customerDatabase.getAllCustomers().size() == 0)
			throw new Exception("No customers registered yet");

		return this.customerDatabase.getAllCustomers();
	}
	public boolean registerCustomer(Customer customer) throws Exception
	{
		if(customer.getEmail() == null || customer.getEmail().isEmpty())
			throw new Exception("email cannot be empty or null");
		try {
			customerDatabase.insertCustomer(customer);

		} catch (Exception e) {
			// lint errors
			throw new Exception(e.getMessage());
		}
		return true;
	}
	public Customer getCustomerByEmail(String email) throws Exception
	{
		if(email==null || email.isEmpty())
			throw new Exception("email cannot be empty or null");
		Customer cust = this.customerDatabase.getCustomerByEmail(email);
		if(cust == null)
			throw new Exception("Customer with email "+email+" does not exist");
		return cust;
	}

	public boolean validateCredentials(String email, String password) throws Exception
	{
		if(email==null || email.isEmpty())
			throw new Exception("email cannot be empty or null");
		
		return this.customerDatabase.login(email, password);
	}
	public boolean updateCustomer(Customer customer) throws Exception
	{
		try {
			this.customerDatabase.updateCustomer(customer);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return true;
	}
	public boolean deleteCustomer(String email) throws Exception
	{
		try {
			this.customerDatabase.deleteCustomer(email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return true;
	}
	public boolean changePassword(String email, String newPassword) throws Exception
	{
		try {
			this.customerDatabase.updatePassword(newPassword, email);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return true;
	}
}
