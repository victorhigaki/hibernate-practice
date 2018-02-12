package com.victorhigaki;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.victorhigaki.entity.Employee;

//			 * Develop code to save objects.

public class SaveObject {

	public static void main(String[] args) {

		// Create a factory session
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {
			// Create a Object
			System.out.println("Creating new object");
			Employee tempEmployee = new Employee("Bill", "Gates", "Microsoft");

			// Begin Transaction
			session.beginTransaction();

			// Save Object
			System.out.println("Saving the Employee...");
			session.save(tempEmployee);

			// Commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		}

		finally {
			factory.close();
		}
	}
}
