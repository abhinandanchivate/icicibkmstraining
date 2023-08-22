package com.icicibk.empms;

import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.icicibk.empms.config.AppConfig;
import com.icicibk.empms.dto.Employee;
import com.icicibk.empms.services.EmployeeService;
import com.icicibk.empms.services.EmployeeServiceImpl;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new 
				AnnotationConfigApplicationContext(AppConfig.class);
		
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		// empService singleton object.
		Employee employee = new Employee("AB001", "abhinandan", "chivate", "pune", 123.00f, "1234567890");
		//String insertResult = employeeService.addEmployee(employee);
		
		//System.out.println("insert Result "+insertResult);
		
		Optional<Employee> optional = employeeService.getEmployeeById("AB001");
		
		if(optional.isEmpty()) {
			System.out.println("there is no record");
		}
		else {
			System.out.println(optional.get());
		}
		
	}

}
