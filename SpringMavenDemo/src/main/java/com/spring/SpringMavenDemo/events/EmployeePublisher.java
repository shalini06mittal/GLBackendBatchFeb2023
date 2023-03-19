package com.spring.SpringMavenDemo.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class EmployeePublisher{// implements ApplicationEventPublisherAware{

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	@Override
//	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//		// TODO Auto-generated method stub
//		this.publisher = applicationEventPublisher;
//		
//	}
	public Employee createNewEmployee()
    {
    	System.out.println("publish create new employee");
        Employee employee =  employeeDAO.createNewEmployee();         
        //publishing the veent here
        publisher.publishEvent(new 	(this, "ADD", employee));
         
        return employee;
    }


}
