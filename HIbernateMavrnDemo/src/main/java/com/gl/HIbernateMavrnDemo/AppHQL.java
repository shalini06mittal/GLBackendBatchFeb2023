
package com.gl.HIbernateMavrnDemo;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HIbernateMavrnDemo.config.HibernateConfig;
import com.gl.HIbernateMavrnDemo.entity.Author;
import com.gl.HIbernateMavrnDemo.entity.Users;


public class AppHQL 
{
	
	
	
	// HQL - Hibernate Query Language
	private static SessionFactory factory;// = HibernateConfig.getSessionFactory();
	public static void main( String[] args )
	{
	
		// 1. where clause
		//    	Session session = factory.openSession();
		//    	
		//    	List<Author> authors ;
		//    	= session.createQuery("from Author where genre=:genre and year=:year",
		//    			Author.class)
		//    			.setParameter("genre", "IT")
		//    			.setParameter("year", 2014)
		//    			.getResultList();
		//    	session.close();
		//    	for(Author author : authors)
		//    		System.out.println(author);

		//    	session = factory.openSession();
		//    	authors = session.createQuery("from Author",
		//    			Author.class)
		//    			.setMaxResults(2)
		//    			.getResultList();
		//    	session.close();
		//    	for(Author author : authors)
		//    		System.out.println(author);

		//    	session = factory.openSession();
		//    	authors = session.createQuery("from Author where name like 'S%'",
		//    			Author.class)
		//    			.getResultList();
		//    	session.close();
		//    	for(Author author : authors)
		//    		System.out.println(author);

		//    	session = factory.openSession();
		//    	Transaction tx = session.beginTransaction();
		//    	Users ob1 = new Users();
		//    	ob1.setEmail("shalini@gmail.com");
		//    	ob1.setPassword("shalini");
		//    	ob1.setDate_created(LocalDate.now());
		//    	long count  = session.createQuery("select count(*) from Author",
		//    			Long.class).uniqueResult();
		//    	session.createQuery("delete from Author where aid=:aid")
		//    	.setParameter("aid", 5).executeUpdate();
		//    	session.save(ob1);
		//    	tx.commit();
		//    	session.close();
		//    	


	}
}
