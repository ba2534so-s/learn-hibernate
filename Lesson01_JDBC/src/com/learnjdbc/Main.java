package com.learnjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		String sql = "SELECT * FROM students WHERE studentID = 3";
		
		String url = "jdbc:postgresql://localhost:5432/students";
		String username = "postgres";
		String password = "0";
		
		try {
			Connection con = DriverManager.getConnection(url , username, password);
			Statement st = con.createStatement();
			
		} catch (Exception e) {
			e.getMessage();
		}
		

	}

}
