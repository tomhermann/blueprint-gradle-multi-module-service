package com.carfax.employee;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/com/carfax/employee/services-context.xml"})
public class CachableEmployeeServiceTest {
	@Autowired
	EmployeeServiceContract cacheableEmployeeService;
	
	EmployeeServiceContract underlyingService;
	@Before
	public void before() throws Exception{
		underlyingService = mock(EmployeeServiceContract.class);
		Advised proxiedObject = (Advised)cacheableEmployeeService;
		CachableEmployeeService target = (CachableEmployeeService)proxiedObject.getTargetSource().getTarget();
		target.setUnderlyingService(underlyingService);
	}
	@Test
	public void shouldCacheSecondResult() throws Exception{
		List<Employee> employees1 = cacheableEmployeeService.list();
		List<Employee> employees2 = cacheableEmployeeService.list();
		
		verify(underlyingService, times(1)).list();
	}
}
