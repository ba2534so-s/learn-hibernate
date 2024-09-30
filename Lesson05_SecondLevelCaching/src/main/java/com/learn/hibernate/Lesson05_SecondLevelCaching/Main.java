package com.learn.hibernate.Lesson05_SecondLevelCaching;

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
        session2.beginTransaction();
         
        e = session2.get(Employee.class, 102);
        System.out.println(e);
        
        session2.getTransaction().commit();
        session2.close();
        
        System.out.println();
        
        Session session3 = sf.openSession();
        session3.beginTransaction();
        
        String hqlQuery = "from Employee where employeeId = :id";
        SelectionQuery<Employee> query = session3.createSelectionQuery(hqlQuery, Employee.class);
        
        query.setParameter("id", 103);
        
        e = query.getSingleResult();
        System.out.println(e);
        
        session3.getTransaction().commit();
        session3.close();
        
        Session session4 = sf.openSession();
        session4.beginTransaction();
        
        query = session4.createSelectionQuery(hqlQuery, Employee.class).setParameter("id", 103);
        e = query.getSingleResult();
        System.out.println(e);
        
        session4.getTransaction().commit();
        session4.close();
        
    }
}
