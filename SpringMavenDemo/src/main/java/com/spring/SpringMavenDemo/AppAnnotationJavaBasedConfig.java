package com.spring.SpringMavenDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringMavenDemo.band.Singer;
import com.spring.SpringMavenDemo.entity.AuthorEntity;
import com.spring.SpringMavenDemo.entity.Book;
import com.spring.SpringMavenDemo.entity.CollDemo;
import com.spring.SpringMavenDemo.events.EmployeePublisher;

//@Configuration // (represents spring configuration)
//@ComponentScan
public class AppAnnotationJavaBasedConfig 
{
    public static void main( String[] args )
    {
       
//        ApplicationContext context = 
//        		new ClassPathXmlApplicationContext("spring-anno.xml");
    	
    	AnnotationConfigApplicationContext context
    	= new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	
        
//    	for(String bean : context.getBeanDefinitionNames())
//    	{
//    		System.out.println(bean);
//    	}
    	
    	CollDemo demo = context.getBean(CollDemo.class);
//    	System.out.println(demo.getAuthors());
//    	System.out.println(demo.getFruits());
//    	System.out.println(demo.getIds());
//    	System.out.println(demo.getMap());
//    	  AuthorEntity a1 = (AuthorEntity) context.getBean("auth");
//        System.out.println(a1);
//        
//	        Book b1 = context.getBean(Book.class);
//	        System.out.println(b1);
//	        
//	        MyAppContext app = context.getBean(MyAppContext.class);
//	        app.m1();
//        
//        Singer ob = context.getBean(Singer.class);
//        ob.details();
	        
	        
	        // event listener
	        EmployeePublisher publisher = context.getBean(EmployeePublisher.class);
	        publisher.createNewEmployee();
	        context.registerShutdownHook();
        
    }
}

/**
 * 1. Create an interface Instrument -> void play()
 * Create 2 classes Guitar and Violin that implements Intrument interface
 * 2. Create a class Singer foll members
 * String name
 * Instrument instrument
 * 
 * details(){
 * 
 * 		// display the name of the singer
 * 		// and the instrument is playing => instrument.play()
 * }
 * 
 */
