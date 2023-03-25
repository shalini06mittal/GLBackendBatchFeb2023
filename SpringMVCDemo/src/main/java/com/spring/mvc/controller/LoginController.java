package com.spring.mvc.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	/**
	 * GET /login -> appends data on the url
	 * it can send only 256 characters
	 * 
	 * POST /login -> sends the data as a payload in the body of the request
	 * it is secured and no limitations on the amount of data you can send
	 * @return
	 */
	//@RequestMapping(path = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request, Map<String, List<String>> map)
	{
		// GET
		System.out.println("login request "+request.getMethod());
		List<String> roles = Arrays.asList("ADMIN","USER","DEV");
		map.put("roles", roles);
		return "login";
	}
	
	//@RequestMapping(path = "/login", method = RequestMethod.POST)
	@PostMapping("/login")
	public String loginPOstPage(@RequestParam String email,
			@RequestParam String password, HttpServletRequest request)
	{
		// POST
		System.out.println("login request "+request.getMethod());
		System.out.println("email "+email);
		System.out.println("pwd "+password);
		if(email.equals("sh@g.c") && password.equals("sh"))
		{
			// success
			return "redirect:dashboard";
		}
		// failure => redirect (GET)
		return "redirect:login";
	}
}
