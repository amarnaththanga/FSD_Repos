package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployees {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;


		try {

			// Create a connection
			conn = DatabaseConnection.getConnection();

			
			// Create a statement
			stmt = conn.createStatement();

			// Read and Execute Query
			String query = "INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`)" 
					+ "VALUES (13,'Snow','White','white.snow@zoo.com', 'Zoo', 80000.00);";

			// Execute Query
			int rows = stmt.executeUpdate(query);
			
			System.out.println("Rows Inserted are" + rows);

			
		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}
}
