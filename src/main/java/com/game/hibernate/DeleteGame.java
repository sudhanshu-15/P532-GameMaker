package com.game.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.hibernate.UserTest;
import com.game.pojos.Game;
import com.game.hibernate.HibernateUtil;

public class DeleteGame {
	public static void main(String[] args) {  
		  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
        session.beginTransaction();  
         
        
        // Removes the game with id -1 ( generally it could be any game)
        
        Game game  = (Game) session.get(Game.class, 1);
        
        
        //UserTest user = (UserTest) session.get(UserTest.class, 1);  
          
        session.delete(game);  
        session.getTransaction().commit();  
          
        session.close();  
  
    }  
}
