package com.gl.boot.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/hello")
	public String greet()
	{
		return "hello";
	}
	@GetMapping("/greet")
	public @ResponseBody String greet1()
	{
		return "<h1 style='color:red'>hello</h1>";
	}
}
