package com.victorhigaki;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.victorhigaki.entity.Employee;

//			 * Develop code to retrieve an object by primary key.
public class RetrieveByPK {

	public static void main(String[] args) {
		
		int Key = 3;
		
		// crate a factory session
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
	
			// start transaction
			session.beginTransaction();
			
			// Id
			System.out.println("Employee Id:" + Key);
			
			// Get Employee by Primary Key
			Employee tempEmployee = session.get(Employee.class, Key);
			System.out.println("Get employee: " + tempEmployee);
			
			// session commit
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}
	}
}
