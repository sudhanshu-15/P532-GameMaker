package com.game.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.hibernate.UserTest;
import com.game.hibernate.HibernateUtil;

public class RetrieveUserTable {
	public static void main(String[] args) {  
		  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
          
        List<UserTest> users = session.createQuery("from UserTest").list();  
          
        session.close();  
          
        for (UserTest st : users) {  
            System.out.println(st.getId()+". "+st.getName()+" "+st.getScore());  
        }  
    }  
}
