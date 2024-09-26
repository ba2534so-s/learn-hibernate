package com.learn.hibernate.Lesson04_FirstLevelCaching;

import jakarta.persistence.Entity;

@Entity
public class Employee {
	
	
	private int employeeId;
	private String name;
	private String role;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", role=" + role + "]";
	}
	
	
	
	
}
