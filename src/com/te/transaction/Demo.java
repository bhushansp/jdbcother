package com.te.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Savepoint setSavepoint = null;
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		
		try {
			connection=DriverManager.getConnection(url,"root","1508");
			statement= connection.createStatement();
			connection.setAutoCommit(false);
			statement.execute("Insert into trans values(1,'Unlock by fingerprint')");
			statement.execute("Insert into trans values(2,'Entering the Pin')");
			statement.execute("Insert into trans values(3,'Check Balance')");
			System.out.println("Balance is 1000000");
			
			setSavepoint=connection.setSavepoint();
			
			statement.execute("Insert into trans values(4,'Debiting the amount')");
			statement.execute("Insert into trans values(5,'Transfer through network')");
			statement.execute("Insert into trans values(6,'Crediting to amount')");
			System.out.println("Transaction Completed!!");
			connection.commit();
			
					
		} catch (SQLException e) {
			try {
				connection.rollback(setSavepoint);
				connection.commit();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			System.out.println("Transaction Failed!");
			e.printStackTrace();
		}

	}

}
