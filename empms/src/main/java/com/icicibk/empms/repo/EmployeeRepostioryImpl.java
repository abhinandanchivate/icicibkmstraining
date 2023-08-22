package com.icicibk.empms.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.icicibk.empms.dto.Employee;
import com.icicibk.empms.utils.DBConnection;

public class EmployeeRepostioryImpl implements EmployeeRepository {
	
	private static EmployeeRepository employeeRepository;
	
	public static EmployeeRepository getInstance() {
		
		if(employeeRepository==null) {
			employeeRepository = new EmployeeRepostioryImpl();
		}
		return employeeRepository;
		
	}

	private EmployeeRepostioryImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// to insert employee details to the DB.
		// 1. get the DB connection
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into employee"
				+ " (empId, empFirstName, empLastName, empAddress, empSalary, contactNumber) "
				+ "values(?,?,?,?,?,?)";
		
		connection = DBConnection.getConnection();
		// 2. provide the details
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpFirstName());
			preparedStatement.setString(3, employee.getEmpLastName());
			preparedStatement.setString(4, employee.getEmpAddress());
			preparedStatement.setDouble(5, employee.getEmpSalary());
			preparedStatement.setString(6, employee.getContactNumber());
			
			int result = preparedStatement.executeUpdate();
			if(result > 0) {
				return "success";
			}
			else {
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(connection);
		}
		// we have to use a statemnt : PreparedStatement: 
		// 3. perform the exectuion of insert statement.
		// 4. finally share the result.
		
		return null;
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
		return Optional.empty();
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
