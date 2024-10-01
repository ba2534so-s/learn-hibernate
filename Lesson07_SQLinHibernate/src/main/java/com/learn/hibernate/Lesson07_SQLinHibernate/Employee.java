package com.learn.hibernate.Lesson07_SQLinHibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	private int employeeId;
	private String name;

}
