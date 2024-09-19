package com.learnjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		
		String sql = "SELECT * FROM students WHERE studentID = 3";
		
		String url = "jdbc:postgresql://localhost:5432/students";
		String username = "postgres";
		String password = "0";
		
		try {
			Connection connection = DriverManager.getConnection(url , username, password);			
		} catch (Exception e) {
			e.getMessage();
		}
		

	}

}
