
package com.gl.HIbernateMavrnDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gl.HIbernateMavrnDemo.config.HibernateConfig;
import com.gl.HIbernateMavrnDemo.entity.Author;

/**
 *1. Create maven project - quickstart
 *		archetype - templates
 *		artifact id - project name
 *		group id - package
 *2. Add hibernate and mysql dependency
 *3. hibernate => needs connection parameters
 *	hibernate.cfg.xml file => src/main/resources
 *	Project => rt click => Build Path => Configure build path
 *	=> Sources tab => Add new folder  => Create nre folder => src/main/resources
 *4. mapping of java class with database table => need a class and add annotations
 *5. add <mapping> tag for your class in hibernate.cfg.xml file
 *6. load the configuration file => hibernateConfig.java
 *
 * Hibernate Architecture / API
 * 
 * Configuration => SessionFactory
 * SessionFactory => long lived and it is available 1 per database
 * appn needs to connect with more than 2 databases => 2 configuration file
 * and 2 session factory objects
 * Session => short lived => created per DB transaction
 * select => update => delete, should close them
 * user1 => checkout => bank tx, stock update, inventory, invoice, shipping, notification
 * Transaction
 */
public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
        Author a1 = new Author("Daniel", "Kids");
//        System.out.println(a1);
//        System.out.println(insertAuthor(a1));
//        System.out.println(a1);
        a1.setName("John Daniels");
        a1.setAid(4);
        System.out.println(a1);
       // System.out.println(updateAuthor(a1));
      //  deleteAuthor(a1);
        System.out.println(getAuthorById(2));
        
        for(Author author : getAllAuthors())
        {
        	System.out.println(author);
        }
    }
    // save or persist
    public static int insertAuthor(Author author)
    {
    	// Create a session
    	// DML commit => transaction
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.persist(author);
    	tx.commit();
    	session.close();
    	return author.getAid();
    }
    /*
     * 3 states of an object
     * 1. transient => newly created
     * 2. persistent => save
     * 3. detached => after you close the seesion
     * merge and update
     */
    public static Author updateAuthor(Author author)
    {
    	// Create a session
    	// DML commit => transaction
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	Author updatedAuthor = session.merge(author);
    	tx.commit();
    	session.close();
    	return updatedAuthor;
    }
    // remove and delete
    public static void deleteAuthor(Author author)
    {
    	// Create a session
    	// DML commit => transaction
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.remove(author);
    	tx.commit();
    	session.close();
    }
    public static Author getAuthorById(int authorid)
    {
    	Session session = factory.openSession();
    	Author author = session.get(Author.class, authorid);
    	session.close();
    	return author;
    }
    public static List<Author> getAllAuthors()
    {
    	Session session = factory.openSession();
    	List<Author> authors = session.createQuery("select a from Author a", Author.class).getResultList();
    	session.close();
    	return authors;
    }
    
    
}
