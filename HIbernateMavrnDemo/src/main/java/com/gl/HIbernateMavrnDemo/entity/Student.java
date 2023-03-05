package com.gl.HIbernateMavrnDemo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	private String technology;
	
	// will not create separate address table but will add all
	// columns of address in the student table itself
	@Embedded
	// one to one
	// residential address
	private Address address;
	
	@ElementCollection
	@JoinTable(name="certificates",
		joinColumns = @JoinColumn(name="studid") )
	
	@Column(name="cert")
	private List<String> certificates;
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}
	
	
	
}
