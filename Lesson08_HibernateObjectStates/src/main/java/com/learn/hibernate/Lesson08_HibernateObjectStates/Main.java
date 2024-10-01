package com.learn.hibernate.Lesson08_HibernateObjectStates;

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
        
        Employee e = new Employee();
        e.setEmployeeId(51);
        e.setName("John Carter");
        e.setSalary(25000);
        
        
        session.getTransaction().commit();
    }
}
