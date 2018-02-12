package com.victorhigaki;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.victorhigaki.entity.Employee;

// 			 * Develop code to query objects to find employees for a given company.
public class CompanyQuery {

	public static void main(String[] args) {

		String key = "apple";
		// create a factory session
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			// Update Object
			List<Employee> theEmployee = session.createQuery("from Employee e where e.company='"+ key +"'").getResultList();

			// Print List
			for ( Employee tempEmployee : theEmployee ) {
				System.out.println(tempEmployee);
			}


			// Commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		}

		finally {
			factory.close();
		}
	}
}
