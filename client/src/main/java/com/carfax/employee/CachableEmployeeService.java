package com.carfax.employee;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.carfax.employee.Employee;
import com.carfax.employee.EmployeeServiceContract;


public class CachableEmployeeService implements EmployeeServiceContract{
	
	private EmployeeServiceContract underlyingService;
	
	@Cacheable("com.carfax.employee")
	public List<Employee> list() {
		return underlyingService.list();
	}

	public Employee add(String firstName, String lastName) {
		return null;
	}

	public void setUnderlyingService(EmployeeServiceContract underlyingService) {
		this.underlyingService = underlyingService;
		
	}

}
