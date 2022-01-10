package com.te.storedprocedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class StoredProDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcdemo";
		Connection connection = null;
		java.sql.CallableStatement callableStatement =null;
		
		try {
			connection = DriverManager.getConnection(url,"root","1508");
			callableStatement = connection.prepareCall("call put(?,?,?,?)");
			//Taking the input from the user
			Scanner scan = new Scanner(System.in);
			while(true) {
				System.out.println("Enter the id of sweet");
				int id = scan.nextInt();
				if(id == 0) {
					break;
				}
				System.out.println("Enter the name of the sweet");
				String name = scan.next();
				System.out.println("Enter the cost of the sweet");
				double price=scan.nextDouble();
				System.out.println("Enter the quantity");
				int quantity = scan.nextInt();
				
				//assigning the values to table
				callableStatement.setInt(1, id);
				callableStatement.setString(2, name);
				callableStatement.setDouble(3, price);
				callableStatement.setInt(4, quantity);
				
				//execute the statement
				callableStatement.execute();
				
			
	}


				
			
		} catch (Exception e) {
			e.printStackTrace();


	}

}
}
