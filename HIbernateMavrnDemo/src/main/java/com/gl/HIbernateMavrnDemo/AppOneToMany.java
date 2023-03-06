
package com.gl.HIbernateMavrnDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HIbernateMavrnDemo.config.HibernateConfig;
import com.gl.HIbernateMavrnDemo.entity.Author;
import com.gl.HIbernateMavrnDemo.entity.Product;
import com.gl.HIbernateMavrnDemo.entity.Store;


public class AppOneToMany 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
	public static void main( String[] args )
	{
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setPname("Laptop");
		p1.setPrice(75000);
		p1.setDescription("Windows MAC OSX");

		products.add(p1);
		p1 = new Product();
		p1.setPname("Keyboard");
		p1.setPrice(18000);
		p1.setDescription("Sony wireless Keyboard");

		products.add(p1);
		
		Store s1 = new Store();
		s1.setProducts(products);
		s1.setStoreid("S003");
		s1.setStorename("Chroma Hyderabad");
		
		//p1.setPid(3);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
//		for(Product p : products)
//			session.save(p);
		//session.remove(s1);
		
		session.persist(s1);
		tx.commit();
		session.close();
	}
}
