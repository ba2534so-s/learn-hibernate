package com.learn.hibernate.Lesson06_HibernateQueryLanguage;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
    	SessionFactory sf = con.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	/* create 50 employees
    	Random rand = new Random();
    	for (int i = 1; i <= 50; i++) {
    		Employee e = new Employee();
    		e.setEmployeeId(i);
    		e.setName("Name " + i);
    		e.setSalary(rand.nextInt(50000));
    		session.persist(e);
    	}
    	*/
    	
    	String hqlQuery = "from Employee";
    	SelectionQuery<Employee> query = session.createSelectionQuery("from Employee", Employee.class);
    	
    	session.getTransaction().commit();
    }
}
