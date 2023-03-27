package com.spring.mvc.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.dto.LoginDTO;
import com.spring.mvc.service.UsersService;

@Controller
public class LoginController {

	@Autowired
	private UsersService usersService;
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
	public String loginPage(HttpServletRequest request,
			Map<String, List<String>> map,
			Map<String, String> errormap,
			@RequestParam(required = false) String error)
	{
		// GET
		if(error != null)
			errormap.put("error", error);
		System.out.println("login request "+request.getMethod());
		List<String> roles = Arrays.asList("ADMIN","USER","DEV");
		map.put("roles", roles);
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:login";
	}
	
	//@RequestMapping(path = "/login", method = RequestMethod.POST)
	@PostMapping("/login")
	public String loginPOstPage(LoginDTO dto, HttpServletRequest request,
			HttpSession session)
	{
		// POST
		System.out.println("login request "+request.getMethod());
		System.out.println("email "+dto.getEmail());
		System.out.println("pwd "+dto.getPassword());
		try {
			if(this.usersService.validateUser(dto))
			{
				session.setAttribute("email", dto.getEmail());
				return "redirect:dashboard";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return "redirect:login?error=Invalid credentials";
		}
		// failure => redirect (GET)
		return "redirect:login?error=Invalid credentials";
	}
//	//@RequestMapping(path = "/login", method = RequestMethod.POST)
//		@PostMapping("/login")
//		public String loginPOstPage(@RequestParam String email,
//				@RequestParam String password, HttpServletRequest request)
//		{
//			// POST
//			System.out.println("login request "+request.getMethod());
//			System.out.println("email "+email);
//			System.out.println("pwd "+password);
//			if(email.equals("sh@g.c") && password.equals("sh"))
//			{
//				// success
//				return "redirect:dashboard";
//			}
//			// failure => redirect (GET)
//			return "redirect:login";
//		}
}
