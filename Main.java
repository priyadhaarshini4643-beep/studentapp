package com.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            Student student = new Student(
                    102,
                    "Priyadharshini",
                    "priya@gmail.com",
                    "AI & Data Science"
            );

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Student saved successfully!");

        } finally {
        	session.close();
            factory.close();
        }
    }
}
