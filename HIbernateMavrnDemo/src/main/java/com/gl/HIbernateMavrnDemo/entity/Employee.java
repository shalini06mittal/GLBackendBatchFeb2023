package com.gl.HIbernateMavrnDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
    private String email;
    private String empname;
    private String phone;
    
    // unidirectional
    @OneToOne
    @JoinColumn(name="identity_id")
    // default <propertyname_id>
    private Identification identification;
    
    public Employee() {
    }

    public Employee(String email, String empname, String phone) {
        this.email = email;
        this.empname = empname;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	@Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", empname='" + empname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
