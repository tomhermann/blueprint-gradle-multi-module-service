package com.carfax.employee;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.annotations.cache.ServerCached;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService implements EmployeeServiceContract{
	@Autowired
	private EmployeeDAO employees;

	public List<Employee> list(){
		return employees.getAll();
	}
	
	public Employee add(String firstName, String lastName){
		if(firstName != null & lastName != null){
			Employee employee = new Employee(firstName:firstName, lastName:lastName);
			employees.save(employee);
			return employee;			
		}
		return null;
	}
}
