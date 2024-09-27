package com.learn.hibernate.Lesson05_SecondLevelCaching;

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
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session1 = sf.openSession();
        session1.beginTransaction();
        
        e = session1.get(Employee.class, 102);
        System.out.println(e);
        
        e = session1.get(Employee.class, 102);
        System.out.println(e);
        
        session1.getTransaction().commit();
        session1.close();
        
        Session session2 = sf.openSession();
    }
}
