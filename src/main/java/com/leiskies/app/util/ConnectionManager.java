package com.leiskies.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection sqlConnection = null;
	private static final String URL = "jdbc:mysql://localhost:3306/study";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "11teddy11";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			sqlConnection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}	catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return sqlConnection;
		
    }
	
	
}