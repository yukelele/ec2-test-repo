package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Driver {

	public static void main(String[] args) {
		
		
		
		// create a session factory 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Fridge.class)
				.buildSessionFactory();
		
		// retrieve the session from the Session Factory
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Fridge: " + session.get(Fridge.class, 4));
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
			factory.close();
		}
	}
	
	
}
