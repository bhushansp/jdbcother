package com.te.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	public static void main(String[] args) {
		Connection connection =null;
		Statement statement = null;
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,"root","1508");
		
			statement = connection.createStatement();
			boolean execute = statement.execute("Insert into sweet values (101,'Gulabjamun',10,1)");
			boolean execute2 = statement.execute("Insert into sweet values (102,'Rasgulla',20,1)");
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
}
