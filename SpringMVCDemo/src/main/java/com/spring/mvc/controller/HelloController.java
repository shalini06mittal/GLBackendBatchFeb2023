package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// req . processes, sends the viewname as the response
@Controller
public class HelloController {

	public HelloController() {
		System.out.println("Hello controller constructor called");
	}
	
	@RequestMapping("/greet")
	public String hellopage()
	{
		System.out.println("greeta called");
		// the string hello should exactly match with the filename hello.jsp
		return "hello";
	}
}
