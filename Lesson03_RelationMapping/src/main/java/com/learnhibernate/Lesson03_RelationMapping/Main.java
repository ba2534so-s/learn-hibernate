package com.learnhibernate.Lesson03_RelationMapping;

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
    }
}
