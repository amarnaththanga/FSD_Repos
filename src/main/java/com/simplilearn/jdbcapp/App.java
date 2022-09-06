package com.simplilearn.jdbcapp;

import java.sql.Connection;

public class App 
{
public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			
			// Create a connection
			conn = DatabaseConnection.getConnection();					
				
			
			if (conn!=null) {
				System.out.println("JDBC Connection is successful");
			}
			else {
				System.out.println("JDBC Connection failed");
			}
			
			// Create a statement
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
