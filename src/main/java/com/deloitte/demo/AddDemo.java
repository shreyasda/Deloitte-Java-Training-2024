package com.deloitte.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddDemo {
public static void main(String[] args) {
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class)
			.buildSessionFactory();
	Session session = factory.getCurrentSession();

	try {
		
		Employee emp = new Employee("Bholu", 87.45	);

		session.beginTransaction();
		
		session.save(emp);

		session.getTransaction().commit();
		
		System.out.println("Done...");

	} catch (Exception e) {
		e.printStackTrace();
	} finally {

		factory.close();
	}
}
}
