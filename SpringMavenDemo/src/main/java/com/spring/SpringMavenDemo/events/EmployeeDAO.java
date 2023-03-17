package com.spring.SpringMavenDemo.events;

import org.springframework.stereotype.Repository;

// semantic
@Repository // @Component @Service @Controller
public class EmployeeDAO {

	public Employee createNewEmployee()
    {
        Employee e = new Employee();
        e.setId(1);
        e.setFirstName("Shalini");
        e.setLastName("Mittal");
        return e;
    }
}
