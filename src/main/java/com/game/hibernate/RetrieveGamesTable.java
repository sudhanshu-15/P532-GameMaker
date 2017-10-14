package com.game.hibernate;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.game.pojos.Game;

public class RetrieveGamesTable {
	
	public RetrieveGamesTable(){
		
	}
		public ArrayList<String> showGames(){  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
        Session session = sessionFactory.openSession();  
          
        ArrayList<String> games = (ArrayList<String>)(session.createSQLQuery("SELECT gameName from Game").list());
    
         System.out.println(" in retrieve class size of gameNames" + games.size());
        session.close();  
        
        System.out.println("Game 0 "+games.get(0));
        return games;
	}
		
		public Game returnSelectedGame(String gameName){  
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();  
	        Session session = sessionFactory.openSession();  
	        
	        String sql_query = "from Game g where s.gameName = '" + gameName + "'";
	          
	        Game game = (Game) session.createQuery(sql_query);
	      
	        System.out.println(" in retrieve game " + game);
	        session.close();  
	        
	       System.out.println(game);
	        return game;
		}
			
     
}
