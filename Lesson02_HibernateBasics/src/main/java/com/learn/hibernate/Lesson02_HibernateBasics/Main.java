package com.learn.hibernate.Lesson02_HibernateBasics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    	s.setStudentId(3);
    	s.setName("Batman");
    	s.setAge(34);
    	s.setGrade('D');
    	
    	
    	// Create Configuration instance and pass in configuration file
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	
    	// Create ServiceRegistry instance
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	
    	 // Build the SessionFactory
    	SessionFactory sf = con.buildSessionFactory(reg);
    	
    	// Open a new Session
    	Session session = sf.openSession();
    	
    	// Start a transaction
    	Transaction tx = session.beginTransaction();
    	
    	// Persist student
    	session.persist(s);
    	
    	// Commit the transaction
    	tx.commit();
    	
    	// close session
    	session.close();
    	sf.close();
    	
    	
    	
    }
}
