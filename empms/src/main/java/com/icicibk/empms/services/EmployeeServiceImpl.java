package com.icicibk.empms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icicibk.empms.dto.Employee;
import com.icicibk.empms.repo.EmployeeRepository;
import com.icicibk.empms.repo.EmployeeRepostioryImpl;

@Service // service should be marked to all services in the application
// which will help us to create singleton object.
public class EmployeeServiceImpl implements EmployeeService {
	// DI.
	@Autowired
	private EmployeeRepository employeeRepository ;
	
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// addEmployee from repo
		return employeeRepository.addEmployee(employee);
	}

	@Override
	public String deleteEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployee(String empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> getEmployeeById(String empId) {
		// TODO Auto-generated method stub
		return employeeRepository.getEmployeeById(empId);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
