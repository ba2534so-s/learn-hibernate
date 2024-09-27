package com.learn.hibernate.Lesson05_SecondLevelCaching;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int employeeId;
	private String name;
	private String role;

}
