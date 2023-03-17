package com.spring.SpringMavenDemo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEventListener implements ApplicationListener<EmployeeEvent> {

	@Override
	public void onApplicationEvent(EmployeeEvent event) {
		System.out.println("\n****************\n");
		System.out.println(event.getEventType());
		System.out.println(event.getSource());
		System.out.println(event.getEmployee());
		System.out.println("\n****************\n");
		// sending a notification
	}

	
}
