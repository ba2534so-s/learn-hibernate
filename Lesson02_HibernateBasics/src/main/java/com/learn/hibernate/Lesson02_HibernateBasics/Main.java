package com.learn.hibernate.Lesson02_HibernateBasics;

import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	Student s = new Student();
    	s.setStudentId(4);
    	s.setName("Spider-Man");
    	s.setAge(18);
    	s.setGrade('D');
    	
    	Configuration con = new Configuration();
    }
}
