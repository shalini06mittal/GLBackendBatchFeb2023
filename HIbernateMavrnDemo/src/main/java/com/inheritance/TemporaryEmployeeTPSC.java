package com.inheritance;

import jakarta.persistence.Entity;

@Entity(name = "temp_tbsc")
public class TemporaryEmployeeTPSC extends EmployeeTPSC {

	private int workingdays;

	public int getWorkingdays() {
		return workingdays;
	}

	public void setWorkingdays(int workingdays) {
		this.workingdays = workingdays;
	}
	
}
