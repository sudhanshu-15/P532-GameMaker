package com.game.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.hibernate.UserTest;
import com.game.hibernate.HibernateUtil;

public class UpdateUser {
	public static void main(String[] args) {  
		  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
          
        UserTest user = (UserTest) session.get(UserTest.class, 1);  
        user.setName("Meow");  
        user.setScore(90);  
          
        session.update(user);  
        session.getTransaction().commit();  
          
        session.close();  
    }  
}
