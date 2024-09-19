package com.learnjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		String sql = "SELECT name FROM students WHERE studentID = 3";
		
		String url = "jdbc:postgresql://localhost:5432/students";
		String username = "postgres";
		String password = "0";
		
		try {
			Connection con = DriverManager.getConnection(url , username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		

	}

}
