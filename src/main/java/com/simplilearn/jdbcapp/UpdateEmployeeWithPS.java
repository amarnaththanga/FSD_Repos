package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployeeWithPS {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;


		try {

			// Create a connection
			conn = DatabaseConnection.getConnection();

			// Read and Execute Query
			String query = "UPDATE `employees` SET `last_name`=? ,`first_name`=?,`email`=?, `department`=?, `salary`=? where id=?";

			
			// Create a statement
			stmt = conn.prepareStatement(query);
			
			// Set parameters
			stmt.setString(1,"Kumar");
			stmt.setString(2,"Raj");
			stmt.setString(3,"kumar.raj@gmail.com");
			stmt.setString(4,"Dev");
			stmt.setDouble(5,99999.00);
			stmt.setInt(6,101);
			

			// Execute Query
			int rows = stmt.executeUpdate();
			
			System.out.println("Rows Updated are" + rows);

			
		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}	
	
}
