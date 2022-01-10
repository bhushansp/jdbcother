package com.te.batchstatement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class BatchStatement {

	public static void main(String[] args) {
		String url = "jdbc:mysql//localhost:3306/jdbcdemo";
		FileReader fileReader;
		Connection connection = null;
		Statement statement = null;

		try {
			fileReader = new FileReader("C:\\Users\\Bhushan\\Desktop\\dbcred.txt");
			Properties properties = new Properties();
			properties.load(fileReader);
			connection = DriverManager.getConnection(url, properties);
			statement = connection.createStatement();
			statement.addBatch("insert into employees values(101,'Bhushan')");
			statement.addBatch("update employees set name ='Gaurav'where id=101");
			statement.addBatch("insert into employees values(103,'Snehal Padole')");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
