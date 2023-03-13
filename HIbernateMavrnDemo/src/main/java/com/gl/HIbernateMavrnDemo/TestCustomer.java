package com.gl.HIbernateMavrnDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HIbernateMavrnDemo.config.HibernateConfig;

public class TestCustomer {

	static SessionFactory factory = HibernateConfig.getSessionFactory();
	public static void main(String[] args) {
		
		//c1.setCid(3);
		CAddress a1 = new CAddress();
		a1.setCity("Mumbai");
		a1.setAid(1);
		
		Customer c1 = new Customer();
		c1.setCname("Shalini");
		c1.setCadddress(a1);
		
		Session sess = factory.openSession();
		Transaction tx = sess.beginTransaction();
		CAddress ob  = sess.get(CAddress.class, 1);
//		sess.persist(a1);
//		sess.persist(c1);
		//Customer ob = sess.get(Customer.class, tx)
		sess.remove(ob);
		tx.commit();

	}

}
