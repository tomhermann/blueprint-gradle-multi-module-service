package com.carfax.employee;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/employees")
public interface EmployeeServiceContract {
	@GET
	@Path("/")	
	@Produces("application/json")
	public List<Employee> list();
	
	@GET
	@Path("/add")
	@Produces("application/json")
	public Employee list(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName);
}
