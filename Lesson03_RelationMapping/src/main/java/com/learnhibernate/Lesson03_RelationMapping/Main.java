package com.learnhibernate.Lesson03_RelationMapping;

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
       Laptop l1 = new Laptop();
       l1.setLaptopID(1);
       l1.setModel("Lenovo");
       
       Student s1 = new Student();
       s1.setStudentID(1);
       s1.setName("Sven");
       s1.setGrade('D');
       
       Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
       SessionFactory sf = con.buildSessionFactory(reg);
       Session session = sf.openSession();
       
       session.beginTransaction();
       
       session.persist(l1);
       
       
    }
}
