package com.game.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InsertUser {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();  
        session.beginTransaction();  
        
        UserTest newUser = new UserTest();
        newUser.setName("Shuwen");
        newUser.setScore(100);
        
        session.save(newUser);
        session.getTransaction().commit();
        
        session.close();
	}
}
