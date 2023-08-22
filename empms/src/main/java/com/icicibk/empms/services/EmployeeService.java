package com.icicibk.empms.services;

import java.util.List;
import java.util.Optional;

import com.icicibk.empms.dto.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);
	public String deleteEmployeeById(String empId);
	public String updateEmployee(String empId, Employee employee);
	public Optional<Employee> getEmployeeById(String empId);
	public List<Employee> getEmployees();
}
