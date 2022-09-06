package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployeeWithPS {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;


		try {

			// Create a connection
			conn = DatabaseConnection.getConnection();

			// Read and Execute Query
			String query = "INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`)" 
					+ "VALUES (?,?,?,?,?,?);";

			
			// Create a statement
			stmt = conn.prepareStatement(query);
			
			// Set parameters
			stmt.setInt(1,101);
			stmt.setString(2,"Kim");
			stmt.setString(3,"Young");
			stmt.setString(4,"kim.young@gmail.com");
			stmt.setString(5,"Engineering");
			stmt.setDouble(6,80889.00);
			

			// Execute Query
			int rows = stmt.executeUpdate();
			
			System.out.println("Rows Inserted are" + rows);

			
		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}
}
