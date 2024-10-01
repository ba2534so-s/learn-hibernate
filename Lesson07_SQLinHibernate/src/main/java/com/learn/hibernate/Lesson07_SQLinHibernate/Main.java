package com.learn.hibernate.Lesson07_SQLinHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
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

        // Using SQL queries in Hibernate 6
        NativeQuery<Employee> query1 = session.createNativeQuery("SELECT * FROM employee WHERE salary > 35000", Employee.class);
        List<Employee> employees1 = query1.list();
        
        for(Employee e : employees1) {
        	System.out.println(e);
        }
        
        session.getTransaction().commit();
        
        session.beginTransaction();
        
        // Getting specific columns
        NativeQuery<Object[]> query2 = session.createNativeQuery(
        		"SELECT name, salary FROM employee where salary > 35000", Object[].class);
        
        List<Object[]> employees2 = query2.list();
        
        for (Object[] o : employees2) {
        	System.out.println(o[0] + ": " + o[1]);
        }
        
        session.getTransaction().commit();
        session.close();
    }
}
