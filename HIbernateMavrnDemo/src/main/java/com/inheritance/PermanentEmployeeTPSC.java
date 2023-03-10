package com.inheritance;

import jakarta.persistence.Entity;

@Entity(name = "pemp_tbsc")

public class PermanentEmployeeTPSC extends EmployeeTPSC {
	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
