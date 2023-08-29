package com.icicibk.empms.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component // signleton in utils package.
public class DBConnection {
	// 
	@Value("${db.url}")
	private  String dbUrl;
	@Value("${db.userName}")
	private  String dbUserName;
	@Value("${db.password}")
	private  String dbPassword;
	
	
	// get coonection 
	// read the properties file
	public  Connection getConnection() {
		
		Connection connection = null;
		
		DBConnection dbConnection = new DBConnection();
		
		
		
		try {
			System.out.println(dbConnection.dbUrl);
			connection = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			return connection;
			
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
