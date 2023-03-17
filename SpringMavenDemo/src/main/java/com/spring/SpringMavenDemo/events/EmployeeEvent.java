package com.spring.SpringMavenDemo.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class EmployeeEvent extends ApplicationEvent{

	private String eventType;
	private Employee employee;
	public EmployeeEvent(Object source,String eventType, Employee employee) {
		super(source);
		this.employee = employee;
		this.eventType = eventType;
		
	}
	public String getEventType() {
		return eventType;
	}
	public Employee getEmployee() {
		return employee;
	}
	
	

}
