package com.game.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.pojos.Game;

public class RetrieveGamesTable {
	
	public RetrieveGamesTable(){
		
	}
		public ArrayList<Game> temp(){  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
          
        ArrayList<Game> games = (ArrayList<Game>) session.createQuery("from Game").list();  
          
        session.close();  
          
        for (Game game : games) {  
            System.out.println(game.getGameId() + "--" + game.getGameName() + "--" + game.getGameSavable());  
        } 
        return games;
	}
     
}


