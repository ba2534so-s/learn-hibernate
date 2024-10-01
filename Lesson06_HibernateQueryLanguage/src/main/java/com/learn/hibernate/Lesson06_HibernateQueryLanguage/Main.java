package com.learn.hibernate.Lesson06_HibernateQueryLanguage;

import java.util.List;
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
    	
    	// get all employees
    	SelectionQuery<Employee> query1 = session.createSelectionQuery("from Employee", Employee.class);
    	
    	// get all employees with a salary above 30,000
    	//SelectionQuery<Employee> query1 = session.createSelectionQuery("from Employee where salary > 30000", Employee.class);
     	List<Employee> employees = query1.getResultList();
    	
    	for (Employee e : employees) {
    		System.out.println(e);
    	}
    	System.out.println();
    	session.getTransaction().commit();
    	session.beginTransaction();
    	// get employee with id 3
    	SelectionQuery<Employee> query2 = session.createSelectionQuery("from Employee where employeeId = 3", Employee.class);
    	Employee e = query2.getSingleResult();
    	System.out.println(e);
    	System.out.println();
    	
    	session.getTransaction().commit();
    	session.beginTransaction();
    	
    	// get certain columns
    	SelectionQuery<Object[]> query3 = session.createSelectionQuery(
    			"select employeeId, name, salary from Employee where employeeId = 2", Object[].class);
    	Object[] employee = query3.getSingleResult();
    	
    	if(employee != null) {
    		System.out.println("Id: " + employee[0] + " - " + employee[1] + " - " + employee[2]);
    	}
    	System.out.println();
    	
    	session.getTransaction().commit();
    	session.beginTransaction();
    	
    	SelectionQuery<Object[]> query4 = session.createSelectionQuery(
    			"select employeeId, name, salary from Employee e where e.salary > 35000", Object[].class);
    	List<Object[]> employeeColumns = query4.getResultList(); 
    	
    	for (Object[] o : employeeColumns) {
    		System.out.println("Id: " + o[0] + " - " + o[1] + " - " + o[2]);
    	}
    	
    	
    }
}
