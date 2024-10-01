package com.learn.hibernate.Lesson10_JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager em = emf.createEntityManager();
        
        // Get employee from db
        Employee e = em.find(Employee.class, 101);
        
        System.out.println(e);
        
        
        // save employee to db
        
        e = new Employee();
        e.setEmployeeId(55);
        e.setName("Bruce Wayne");
        e.setSalary(33000);
        
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
    }
}
