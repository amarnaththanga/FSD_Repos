package com.simplilearn.jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployees {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;

		try {

			// Create a connection
			conn = DatabaseConnection.getConnection();

			if (conn != null) {
				System.out.println("JDBC Connection is successful");
			} else {
				System.out.println("JDBC Connection failed");
			}

			// Create a statement
			stmt = conn.createStatement();

			// Read and Execute Query
			String query = "Select * from employees";

			rst = stmt.executeQuery(query);

			// Read result set
			while (rst.next()) {

				System.out.println("--------------------------------------------");
				System.out.println(rst.getInt("id"));
				System.out.println(rst.getString("first_name"));
				System.out.println(rst.getString("last_name"));
				System.out.println(rst.getString("email"));
				System.out.println(rst.getDouble("salary"));
				System.out.println(rst.getString("department"));

			}

		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}
}
