package com.practice;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        Student student = new Student();

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Student");
            List<Student> students = q.getResultList();
            student = session.get(Student.class, 1);
            tx.commit();
            System.out.println(student);
            System.out.println(students);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
