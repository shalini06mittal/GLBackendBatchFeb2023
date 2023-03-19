package com.spring.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.database.CustomerDB;

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
        System.out.println(cdb.getCustomerCount());
    }
}
