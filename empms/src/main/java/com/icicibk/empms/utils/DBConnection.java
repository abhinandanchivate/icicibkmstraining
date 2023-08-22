package com.icicibk.empms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	// get coonection 
	// read the properties file
	public static Connection getConnection() {
		
		Connection connection = null;
		InputStream inputStream = DBConnection.class
				.getResourceAsStream("application.properties");
		
		Properties properties=new Properties();
		try {
			properties.load(inputStream);
			connection = DriverManager.getConnection(
					properties.getProperty("db.url"), 
					properties.getProperty("db.userName"), 
					properties.getProperty("db.password"));
			return connection;
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
