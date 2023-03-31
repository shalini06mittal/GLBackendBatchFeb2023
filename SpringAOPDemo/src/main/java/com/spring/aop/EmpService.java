package com.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmpService {
	

	private String name;
	
	public EmpService() {
		//System.out.println("emp service created");
	}
	public String getName() {
		System.out.println("Get name");
		return name;
	}
	@Value("shalini")
	public void setName(String name) {
		System.out.println("Set name "+name);
		this.name = name;
	}
	public String applyNow()
	{
		System.out.println("Emp Servcie apply now called");
		return "Done";
	}
	public void applyThen() throws Exception
	{
		System.out.println("Emp Servcie apply THEN called");
		throw new Exception("emp service threw an exception");
	}
}
