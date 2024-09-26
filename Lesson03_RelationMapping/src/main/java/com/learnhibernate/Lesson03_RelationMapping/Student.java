package com.learnhibernate.Lesson03_RelationMapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int studentID;
	private String name;
	private char grade;
	
	//@OneToOne
	//private Laptop laptop;
	//@OneToMany(mappedBy="student")
	//private List<Laptop> laptops = new ArrayList<>();
	@ManyToMany(mappedBy="students")
	private List<Laptop> laptops = new ArrayList<>();
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	

	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	@Override
	public String toString() {
		return this.getName();
	}
	

}
