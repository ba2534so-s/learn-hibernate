package com.learn.hibernate.Lesson02_HibernateBasics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

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
    	
    	
    	// Create Configuration instance and pass in configuration file
    	Configuration con = new Configuration().configure();
    	
    	// Create ServiceRegistry instance
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();

    	
    }
}
