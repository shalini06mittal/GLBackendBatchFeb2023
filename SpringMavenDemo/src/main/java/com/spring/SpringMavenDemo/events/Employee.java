package com.spring.SpringMavenDemo.events;

public class Employee {

	private Integer id;
    private String firstName;
    private String lastName;
    
    public Employee() {
		// TODO Auto-generated constructor stub
	}
    
	public Employee(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
 
}
