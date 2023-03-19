package com.spring.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.database.CustomerDB;
import com.spring.jdbc.entity.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = 
        		new AnnotationConfigApplicationContext(AppConfig.class);
        
        CustomerDB cdb = context.getBean(CustomerDB.class);
        System.out.println(cdb.getTemplate());
        System.out.println("\n***** COUNT *******\n");
        System.out.println(cdb.getCustomerCount());
        Customer cust = cdb.getCustomerByEmail("ab@g.c");
        System.out.println("\n***** Get By Email *******\n");
        System.out.println(cust);
        
        cust.setCity("Noida");
        cust.setPhone("1212121212");
        cust.setCustname("Amit Kumar");
        
        System.out.println("\n***** UPDATE *******\n");
        try {
			System.out.println(cdb.updateCustomer(cust));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Customer c1 = new Customer();
        c1.setEmail("shalini@gmail.com");
        c1.setCustname("Shalini ");
        c1.setCity("Mumbai");
        c1.setPassword("sh");
        c1.setPhone("9999999999");
        
        System.out.println("\n***** INSERT *******\n");
        try {
			System.out.println(cdb.insertCustomer(c1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("\n***** INSERT SAME RECORD *******\n");
        try {
			System.out.println(cdb.insertCustomer(c1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("\n***** ALl Customers *******\n");
        for(Customer c : cdb.getCustomers())
        	System.out.println(c);
        
        System.out.println("\n***** DELETE *******\n");
        try {
			System.out.println(cdb.deleteCustomer("cd@g.c"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
