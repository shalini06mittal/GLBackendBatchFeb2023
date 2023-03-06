package com.gl.HIbernateMavrnDemo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="store")
public class Store {

	@Id
	private String storeid;
	private String storename;
	
	// unidirectional
	@OneToMany( //fetch = FetchType.EAGER,
			cascade = {  CascadeType.ALL}, mappedBy = "store")
	//@JoinColumn(name="storeid")
	private List<Product> products;
	
	public String getStoreid() {
		return storeid;
	}
	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
