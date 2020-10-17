package com.vjsb.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vjsb.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query student
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			// display students
			displayStudents(theStudent);
			
			// query students: lastName="Jain"
			theStudent = session.createQuery("from Student s where s.lastName='Jain'").getResultList();
			
			// display students
			System.out.println("\nStudents who have last name of Jain");
			displayStudents(theStudent);
			
			
			// query students: lastName="Jain" OR firstName="Boom"
			theStudent = session.createQuery("from Student s where"
										+ " s.lastName='Jain' OR s.firstName='Boom'").getResultList();
			
			System.out.println("\nStudents who have last name of Jain and first name of Boom");
			displayStudents(theStudent);
			
			// query students where email LIKE '%gmail.com'
			theStudent = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").getResultList();
			
			System.out.println("\nEmail ending with gmail.com");
			displayStudents(theStudent);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		}

	private static void displayStudents(List<Student> theStudent) {
		for (Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
