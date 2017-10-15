package com.game.model;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JLabel;

public class ScoreReadout extends JLabel implements Serializable{
	
		private String text;
		private int score;
		public boolean isScoreSet = false;
	    JLabel scoreReadout = new JLabel(" Score : 0 ");
	    
        public ScoreReadout() {
        text = " Score : 0 ";        
        scoreReadout.setText("Score: " + score);
	    }

       public ScoreReadout(ScoreReadout scoreReadout) {
    	   scoreReadout.setBounds(40, 45, 40, 40);
           scoreReadout.setFont(new Font("Serif", Font.BOLD, 30));
   	       scoreReadout.setForeground (Color.GREEN);
    	   scoreReadout.setText("Score: " + score);
	       scoreReadout.setVisible(true);
	    }
	
       public int getScore() {
    	   		   return score;
	    }
	
	    public void setScore(int score) {
	               this.score = score;
	    }
	
	    public String getText() {
	               return text;
	    }
	       
	    public void setText(String text) {
	               this.text = text;
	    }
	
	    public void reset() {
	               this.setText(text);
	               this.setScore(0);
	    }     
	}