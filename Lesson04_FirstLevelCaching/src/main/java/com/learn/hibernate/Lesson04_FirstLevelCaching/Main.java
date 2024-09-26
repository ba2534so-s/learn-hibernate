package com.learn.hibernate.Lesson04_FirstLevelCaching;

import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Configuration con = new Configuration().configure().addAnnotatedClass(null);
    }
}
