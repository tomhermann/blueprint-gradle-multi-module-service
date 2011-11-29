package com.carfax.employee;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/com/carfax/employee/services-context.xml"})
public class EmployeeServiceClientTest {
	@Resource
	EmployeeServiceContract client;
	
	@Test
	public void shouldBeAbleToGetEmployeesFromIt(){
		List<Employee> employees = client.list();
		for(Employee employee: employees){
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
		}
	}
}
