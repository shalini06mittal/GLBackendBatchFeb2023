
package com.gl.HIbernateMavrnDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gl.HIbernateMavrnDemo.config.HibernateConfig;
import com.gl.HIbernateMavrnDemo.entity.Employee;
import com.gl.HIbernateMavrnDemo.entity.Identification;

public class AppOneToOne 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
    	// 1. where clause
    	Session session = factory.openSession();
    	Employee emp = session.get(Employee.class, "riya@gmail.com");
    	session.close();
    	System.out.println(emp.getEmail());
    	System.out.println(emp.getEmpname());
    	System.out.println(emp.getIdentification().getFullname());
    	
    	System.out.println();
    	session = factory.openSession();
    	Identification ob = session.get(Identification.class, "A001");
    	session.close();
    	System.out.println(ob.getBdate());
    	System.out.println(ob.getFullname());
    	System.out.println(ob.getEmp().getEmail());
    	
    	
    	
    }
}
