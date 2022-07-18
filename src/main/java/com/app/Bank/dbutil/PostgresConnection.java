package com.app.Bank.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection {

	private static Connection connection;
	
	public PostgresConnection() {
		
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

			
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String username = "postgres";
			String password = "github43";
			connection = DriverManager.getConnection(url, username, password);
			return connection;
	}
	

}
