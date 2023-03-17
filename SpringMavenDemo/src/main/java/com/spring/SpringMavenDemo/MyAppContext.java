package com.spring.SpringMavenDemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.spring.SpringMavenDemo.entity.Book;

@Component

public class MyAppContext implements ApplicationContextAware{

	private ApplicationContext  context;
	
	public MyAppContext() {
		System.out.println("app cntext constructor");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		
	}
	@PostConstruct
	public void setUp()
	{
		System.out.println("some initialization code");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.out.println("some code before bean gets destroyed");
	}
	
	public void m1()
	{
		System.out.println(context);
		Book book = context.getBean(Book.class);
		System.out.println(book);
	}

}
