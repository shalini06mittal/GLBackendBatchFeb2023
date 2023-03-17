package com.spring.SpringMavenDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringMavenDemo.entity.AuthorEntity;
import com.spring.SpringMavenDemo.entity.Book;

/**
 * 1. Quickstart maven project
 * 2. Add spring-context maven dependency in pom.xml file
 * 3. do change java version in pom.xml if required
 * 4. create a class that represents data - Author
 * VVIMP -> follow the package structure
 * 5. to create a spring.xml file under src/main.resources folder
 * 6. configure Author class in xml file as a bean
 * 7. Load the xml file
 */
public class App 
{
    public static void main( String[] args )
    {
       
        // create the spring applciation context and load all the beans
        // specified in the xml file and instantiate them
        // when are the beans loaded
    	// BeanFactory factory = new lazy loading
    	
        ApplicationContext context =
        		new ClassPathXmlApplicationContext("spring.xml");
        System.out.println( "Hello World!" );
        // ambiguity which Author?
//        Author author = context.getBean(Author.class);
//        System.out.println(author);
        
        // by default spring creates single instance of a bean
        // singleton pattern
        AuthorEntity author1 = (AuthorEntity) context.getBean("a1");
        System.out.println("1: "+author1.getAname());
        
        AuthorEntity author11 = (AuthorEntity) context.getBean("a1");
        System.out.println("2: "+author11.getAname());
        
        author1.setAname("Amith Singh");
        System.out.println("3: "+author1.getAname());
        System.out.println("4: "+author11.getAname());
        
        
        Book book = context.getBean(Book.class);
        System.out.println(book);
        
//        Author author2 = (Author) context.getBean("a2");
//        System.out.println(author2);
        
    }
}
