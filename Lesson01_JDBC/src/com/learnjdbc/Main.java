package com.learnjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

	public static void main(String[] args) {
		
		String sql = "SELECT * FROM students WHERE studentID = 3";
		
		String url = "";
		
		Connection connection = DriverManager.getConnection(url , username, password);
		

	}

}
