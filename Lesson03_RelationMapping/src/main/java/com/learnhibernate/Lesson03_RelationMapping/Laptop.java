package com.learnhibernate.Lesson03_RelationMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
	
	@Id
	private int laptopID;
	private String model;
	
	private Student student;
	
	
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
	
	

}
