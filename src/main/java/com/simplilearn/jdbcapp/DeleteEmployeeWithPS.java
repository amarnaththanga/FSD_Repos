package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployeeWithPS {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;


		try {

			// Create a connection
			conn = DatabaseConnection.getConnection();

			// Read and Execute Query
			String query = "DELETE from `employees` where id=?";

			
			// Create a statement
			stmt = conn.prepareStatement(query);
			
			// Set parameters
			stmt.setInt(1,101);
			

			// Execute Query
			int rows = stmt.executeUpdate();
			
			System.out.println("Rows Deleted are" + rows);

			
		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}	
	
}
