package com.carfax.employee.configuration

import javax.sql.DataSource

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.jndi.JndiAccessor

@Configuration
@ImportResource(['classpath:springmvc-resteasy.xml', 'classpath:com/carfax/employee/jndi-context.xml'])
@ComponentScan(basePackages = "com.carfax.employee", 
	excludeFilters = [@Filter(Configuration)])
class AppConfig {
	
}
