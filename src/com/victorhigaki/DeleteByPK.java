package com.victorhigaki;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.victorhigaki.entity.Employee;

//			 * Develop code to delete an object by primary key. 
public class DeleteByPK {

	public static void main(String[] args) {

		int Key = 3;
		
		// crate a factory session
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// crate a session
		Session session = factory.getCurrentSession();
		
		try {
			// retrieve Employee by primary key id
			Employee tempEmployee = session.get(Employee.class, Key);
			
			// Delete Object
			System.out.println("Deleting student: " + tempEmployee);
			session.delete(tempEmployee);

			// Commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		}

		finally {
			factory.close();
		}
	}
}
