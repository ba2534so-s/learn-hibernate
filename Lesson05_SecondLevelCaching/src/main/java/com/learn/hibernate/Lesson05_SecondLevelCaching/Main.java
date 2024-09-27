package com.learn.hibernate.Lesson05_SecondLevelCaching;

import org.hibernate.cfg.Configuration;

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
        
        
    }
}
