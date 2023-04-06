package com.gl.boot;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// global advice
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleEntityExistsException(EntityNotFoundException e)
	{
		System.out.println("error for entity not found");
		Map<String, String> map = new HashMap<>();
		map.put("ERROR", e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
	
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleMediaTypeException(HttpMediaTypeNotAcceptableException e)
	{
		System.out.println("error");
		Map<String, String> map = new HashMap<>();
		map.put("ERROR", e.getMessage());
		return ResponseEntity.badRequest().body(map);
	}
}
