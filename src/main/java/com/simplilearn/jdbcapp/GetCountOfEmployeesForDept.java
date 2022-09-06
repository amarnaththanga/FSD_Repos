package com.simplilearn.jdbcapp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class GetCountOfEmployeesForDept {

	public static void main(String[] args) {

		Connection conn = null;
		CallableStatement stmt = null;

 
		try {

			// Create a connection
			conn = DatabaseConnection.getConnection();
			
			stmt = conn.prepareCall("{call get_count_for_department(?,?)}");

			
			String dept = "HR";
			// Set parameters
			stmt.setString(1,dept);  // input parameter to callable statement
			
			stmt.registerOutParameter(2, Types.INTEGER);
			
			// Create a statement
			stmt.execute() ;
					

			// collect the output
			int cnt = stmt.getInt(2);
			
			System.out.println(dept + " Department count is - " + cnt);

			
		} catch (SQLException e) {
			System.out.println("Exception Occured : " + e.getClass());
			System.out.println("Exception Message : " + e.getMessage());
		}
	}	

}
