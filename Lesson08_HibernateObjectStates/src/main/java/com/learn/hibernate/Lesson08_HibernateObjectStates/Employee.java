package com.learn.hibernate.Lesson08_HibernateObjectStates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int employeeId;
	private String name;

}
