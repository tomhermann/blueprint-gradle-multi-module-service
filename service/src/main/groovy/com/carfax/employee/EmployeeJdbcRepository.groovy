package com.carfax.employee;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class EmployeeJdbcRepository {
	private final JdbcTemplate template;
	
	@Autowired
	public EmployeeJdbcRepository(DataSource dataSource) {
		template = new JdbcTemplate(dataSource)
	}
	
	void save(Employee employee){
		String sql = "INSERT INTO employees (first_name, last_name) VALUES (?, ?)"
		template.update(sql, employee.firstName, employee.lastName)
	}
	
	List<Employee> getAll() {
		template.query("SELECT * FROM employees", BeanPropertyRowMapper.newInstance(Employee.class))
	}
}
