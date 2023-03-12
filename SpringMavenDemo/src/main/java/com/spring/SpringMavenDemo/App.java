package com.spring.SpringMavenDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringMavenDemo.entity.Author;

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
        System.out.println( "Hello World!" );
        // create the spring applciation context and load all the beans
        // specified in the xml file and instantiate them
        ApplicationContext context =
        		new ClassPathXmlApplicationContext("spring.xml");
        // ambiguity which Author?
//        Author author = context.getBean(Author.class);
//        System.out.println(author);
        
        Author author1 = (Author) context.getBean("a1");
        System.out.println(author1);
        
        Author author2 = (Author) context.getBean("a2");
        System.out.println(author2);
        
    }
}
