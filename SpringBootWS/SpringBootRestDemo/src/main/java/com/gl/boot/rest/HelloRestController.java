package com.gl.boot.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// REST API do not generate html pages  or views
// used to transfer data => json or xml
@RestController // @Controller + @ResponseBody
public class HelloRestController {

	@GetMapping("/rest")
	public String getData()
	{
		return "GET DATA";
	}
	@GetMapping("/rest/{id}")
	public String getDataForId(@PathVariable String id)
	{
		return "GET DATA for "+id;
	}
	@PostMapping("/rest")
	public String postData()
	{
		return "POST DATA";
	}
	@PutMapping("/rest")
	public String putData()
	{
		return "PUT DATA";
	}
	@DeleteMapping("/rest")
	public String deleteData()
	{
		return "DELETE DATA";
	}
	
}
