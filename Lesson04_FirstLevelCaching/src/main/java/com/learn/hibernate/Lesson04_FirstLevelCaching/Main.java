package com.learn.hibernate.Lesson04_FirstLevelCaching;

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
        Employee e = null;
        e.setEmployeeId(101);
        e.setName("John Smith");
        e.setRole("Salesman");
        
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();
        
        session1.getTransaction().commit();
        
    }
}
