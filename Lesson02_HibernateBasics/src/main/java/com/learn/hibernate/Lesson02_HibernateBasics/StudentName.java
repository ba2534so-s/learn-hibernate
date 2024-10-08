package com.learn.hibernate.Lesson02_HibernateBasics;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentName {
	
	private String fName;
	private String mName;
	private String lName;
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public String toString() {
		return this.getfName() + " " + this.getmName() + " " + this.getlName(); 
	}

	
	
}
