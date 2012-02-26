package com.carfax.employee.configuration


import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource(['classpath:springmvc-resteasy.xml', 'classpath:com/carfax/employee/jndi-context.xml'])
@ComponentScan(basePackages = "com.carfax.employee", excludeFilters = [@Filter(Configuration.class)])
class AppConfig extends WebMvcConfigurerAdapter {
	
	void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable()
	}
}
