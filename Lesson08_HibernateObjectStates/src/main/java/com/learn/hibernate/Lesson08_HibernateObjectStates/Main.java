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
        e.setEmployeeId(53);
        e.setName("Cameron Dean");
        e.setSalary(25000);
        // Employee e is currently in TRANSIENT state since it hasn't been added to the db yet
        
        // Employee e now goes into PERSISTENT state and changes can still be made to the object
        session.persist(e);
        e.setSalary(28000);
        
        // Remove employee from table. EMployee goes into REMOVED STATE and won't be saved to db
        session.remove(e);
        
        // Employee desn't get saved to table until it's committed
        session.getTransaction().commit();
        
        
        // Employee e now goes into detached state and changes wont get saved in the db
        session.detach(e);
        e.setSalary(10000);
    }
}
