package com.te.jdbcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateTable {
	public static void main(String[] args) {
		Connection connection = null;
		Statement createStatement = null;
		try {
			// 1st step loading or register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			// Create a connection

			 connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/jdbcdemo?user=root&password=1508");

			// 3rd step creating a platform(Statement)

			createStatement = connection.createStatement();

			// 4th execute query

			createStatement.execute("create table Sweet (id int,name varchar(40),cost double,quality int)");
		} catch (SQLException e) {
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
		if (createStatement != null) {
			try {
				createStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
