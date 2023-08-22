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
		
		
		Properties properties=new Properties();
		try(InputStream inputStream = DBConnection.class.getClassLoader().
				getResourceAsStream("application.properties")) {
			System.out.println(inputStream==null);
			properties.load(inputStream);
			System.out.println(properties);
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
