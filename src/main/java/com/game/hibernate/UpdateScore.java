package com.game.hibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.pojos.ScoreSheet;

public class UpdateScore {


	private int gameId;
	private String gameName;
	private int playerId;
	private String playerName;
	private int score;
	
	public UpdateScore(int score){
		this.score = score;
		//updateScore();
	}
	
	
	public void updateScore() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();  
	    session.beginTransaction();  
	    
	    ScoreSheet scoreSheet = new ScoreSheet();
	    scoreSheet.setGameName(gameName);
	    scoreSheet.setGameId(gameId);
	    scoreSheet.setPlayerName(playerName);
	    scoreSheet.setGameId(playerId);
	    scoreSheet.setScore(score);
	    
	    session.save(scoreSheet);
	    session.getTransaction().commit();
	    
	    session.close();
	}
	
	public boolean isGameAlreadyPlayedByUser(){
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		    Session session = sessionFactory.openSession();
			
			System.out.println( "in update score" +score);
			
			String sql_query = "select * from ScoreSheet where playerId = '" + playerId + "' AND gameId = '" + gameId + "'" ;
			
			ArrayList<ScoreSheet> score = (ArrayList<ScoreSheet>) session.createSQLQuery(sql_query).addEntity(ScoreSheet.class).list();
			session.close();
			System.out.println("score size"+score.size());
			if(score.isEmpty())
				return false;
			else
				return true;
	}

}