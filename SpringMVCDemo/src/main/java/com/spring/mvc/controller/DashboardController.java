package com.spring.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String dashboardPage(HttpSession session)
	{
		String email = (String) session.getAttribute("email");
		if(email == null)
			return "redirect:login";
		return "dashboard";
	}
}
