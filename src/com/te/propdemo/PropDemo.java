package com.te.propdemo;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class PropDemo {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
//			FileReader fileReader = new FileReader("C:\\Users\\Bhushan\\Desktop\\jdbc.txt");
//			Properties properties = new Properties();
//			properties.load(fileReader);
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","1508");
			statement = connection.createStatement();
			statement.execute("create table halwa (name varchar(40)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
