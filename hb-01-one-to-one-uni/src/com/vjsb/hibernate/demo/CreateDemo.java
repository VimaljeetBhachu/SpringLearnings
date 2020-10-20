package com.vjsb.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vjsb.hibernate.demo.entity.Instructor;
import com.vjsb.hibernate.demo.entity.InstructorDetails;
import com.vjsb.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration() 
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetails.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			Instructor tempInstructor = new Instructor("Naman", "Mathur", "mathurnaman@mortal.com");
			InstructorDetails tempInstructorDetails = new InstructorDetails("http://www.youtube/morTaL", "Gaming");
			
			// associate the objects
			tempInstructor.setInstructorDetails(tempInstructorDetails);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of the CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
 			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		}

}
