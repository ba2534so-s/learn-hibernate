package com.learn.hibernate.Lesson09_GetVsLoad;

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
    	Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        // Getting Employee with get method
        Employee eGet = session.get(Employee.class, 101);
        System.out.println(eGet);
        
        // Getting Employee with load. Load returns a proxy and only hits the database when the object is used in a method
        Employee eLoad = session.load(Employee.class, 101);
        System.out.println(eLoad);
        
        session.getTransaction().commit();
    }
}
