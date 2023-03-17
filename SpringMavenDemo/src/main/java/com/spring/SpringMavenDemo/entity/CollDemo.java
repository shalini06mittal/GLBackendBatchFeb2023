package com.spring.SpringMavenDemo.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollDemo {

	@Autowired
	private List<String> fruits;
	@Autowired
	private Set<Integer> ids;
	@Autowired
	private Map<String, Integer> map;
	@Autowired
	private List<AuthorEntity> authors;
	
	
	public List<AuthorEntity> getAuthors() {
		return authors;
	}
	public void setAuthors(List<AuthorEntity> authors) {
		this.authors = authors;
	}
	public List<String> getFruits() {
		return fruits;
	}
	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}
	public Set<Integer> getIds() {
		return ids;
	}
	public void setIds(Set<Integer> ids) {
		this.ids = ids;
	}
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
	
}
