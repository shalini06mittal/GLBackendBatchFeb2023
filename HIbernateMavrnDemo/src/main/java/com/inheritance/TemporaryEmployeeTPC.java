package com.inheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "temp_tbc")
@DiscriminatorValue("TEMP")
public class TemporaryEmployeeTPC extends EmployeeTPC {

	private int workingdays;

	public int getWorkingdays() {
		return workingdays;
	}

	public void setWorkingdays(int workingdays) {
		this.workingdays = workingdays;
	}
	
}
