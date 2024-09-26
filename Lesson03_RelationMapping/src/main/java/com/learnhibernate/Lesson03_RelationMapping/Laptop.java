package com.learnhibernate.Lesson03_RelationMapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
	
	@Id
	private int laptopID;
	private String model;
	
	//@ManyToOne
	//private Student student;
	@ManyToMany
	private List<Student> students = new ArrayList<>();
	
	public int getLaptopID() {
		return laptopID;
	}
	public void setLaptopID(int laptopID) {
		this.laptopID = laptopID;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return getModel();
	}
	
	

}
