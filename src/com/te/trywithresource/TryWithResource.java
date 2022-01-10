package com.te.trywithresource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TryWithResource {

	public static void main(String[] args) {
		String str = "jdbc:mysql://localhost:3306/jdbcdemo?user=root&password=1508";
		try (Connection con = DriverManager
				.getConnection(str);
				Statement stmt = con.createStatement();) {
			boolean execute = stmt.execute("select * from sweet");
			System.out.println(execute);

		} catch (Exception e) {

		}

	}

}
