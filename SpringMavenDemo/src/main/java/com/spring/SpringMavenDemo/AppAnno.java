package com.spring.SpringMavenDemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringMavenDemo.entity.AuthorEntity;
import com.spring.SpringMavenDemo.entity.Book;

public class AppAnno 
{
    public static void main( String[] args )
    {
       
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("spring-anno.xml");
        
        AuthorEntity a1 = context.getBean(AuthorEntity.class);
        System.out.println(a1);
        
        Book b1 = context.getBean(Book.class);
        System.out.println(b1);
        
    }
}
