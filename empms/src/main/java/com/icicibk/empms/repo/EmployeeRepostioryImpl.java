package com.icicibk.empms.repo;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.icicibk.empms.dto.Employee;
import com.icicibk.empms.utils.DBConnection;


@Repository
// this annotation will infrom the spring that here you have to create a singleton object
// of repo implementation.
public class EmployeeRepostioryImpl implements EmployeeRepository {

	

	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// to insert employee details to the DB.
		// 1. get the DB connection
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertStatement = "insert into employee"
				+ " (empId, empFirstName, empLastName, empAddress, empSalary, contactNumber) " + "values(?,?,?,?,?,?)";

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
			if (result > 0) {
				return "success";
			} else {
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

		String query = "select * from employee where empId=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBConnection.getConnection();
		ResultSet resultSet = null;
		Employee employee = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, empId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				employee = new Employee();

				employee.setEmpId(resultSet.getString("empId"));
				employee.setEmpFirstName(resultSet.getString("empFirstName"));
				employee.setEmpLastName(resultSet.getString("empLastName"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				employee.setEmpAddress(resultSet.getString("empAddress"));
				employee.setContactNumber(resultSet.getString("contactNumber"));
				// we have to collect the row / employee details

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(connection);
		}

		// TODO Auto-generated method stub
		return Optional.ofNullable(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		String query = "select * from employee";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DBConnection.getConnection();
		ResultSet resultSet = null;
		Employee employee = null;
		List<Employee> employeeList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(query);
			

			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				employee = new Employee();

				employee.setEmpId(resultSet.getString("empId"));
				employee.setEmpFirstName(resultSet.getString("empFirstName"));
				employee.setEmpLastName(resultSet.getString("empLastName"));
				employee.setEmpSalary(resultSet.getFloat("empSalary"));
				employee.setEmpAddress(resultSet.getString("empAddress"));
				employee.setContactNumber(resultSet.getString("contactNumber"));
				// we have to collect the row / employee details
				employeeList.add(employee);

			}
			return employeeList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(connection);
		}
		return null;
	}

}
