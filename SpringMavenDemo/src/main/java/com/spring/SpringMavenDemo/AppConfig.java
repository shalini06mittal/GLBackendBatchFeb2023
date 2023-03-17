package com.spring.SpringMavenDemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.SpringMavenDemo.entity.AuthorEntity;


@Configuration // (represents spring configuration)
@ComponentScan(basePackages = {"bean","com.spring.SpringMavenDemo"})
public class AppConfig {

	@Bean
	public AuthorEntity authorEntity()
	{
		System.out.println("author entity created");
		return new AuthorEntity();
	}
	@Bean
	public List<String> getFruits()
	{
		return Arrays.asList("Apples","Oranges","Banana");
	}
	@Bean
	public Set<Integer> getIds()
	{
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		return ids;
	}
	@Bean
	public Map<String, Integer> getMap()
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("K1", 1);
		map.put("K2", 2);
		map.put("K3", 3);
		return map;
	}
	
	@Bean
	public List<AuthorEntity> getAuthors()
	{
		return Arrays.asList(authorEntity());
	}
}
