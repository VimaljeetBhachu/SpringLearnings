package com.vjsb.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vjsb.hibernate.demo.entity.Instructor;
import com.vjsb.hibernate.demo.entity.InstructorDetails;
import com.vjsb.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int theId = 229;
			InstructorDetails tempInstuctorDetail = session.get(InstructorDetails.class, theId);

			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstuctorDetail);

			// print the associated instructor
			System.out.println("the associated instructor: " + tempInstuctorDetail.getInstructor());
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	} 
}