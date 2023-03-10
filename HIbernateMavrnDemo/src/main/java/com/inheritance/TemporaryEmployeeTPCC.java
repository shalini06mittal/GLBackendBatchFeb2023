package com.inheritance;

import jakarta.persistence.Entity;

@Entity(name = "temp_tbcc")
public class TemporaryEmployeeTPCC extends EmployeeTPCC {

	private int workingdays;

	public int getWorkingdays() {
		return workingdays;
	}

	public void setWorkingdays(int workingdays) {
		this.workingdays = workingdays;
	}
	
}
