package com.game.model;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JLabel;

public class ScoreReadout implements Serializable{
		
	    private static final long serialVersionUID = 10L;
		private int score;
		public boolean isScoreSet = false;
	
        public ScoreReadout() {
            score = 0;
	    }

       public int getScore() {
	      return score;
	    }
	
	    public void setScore(int score) {
	               this.score = score;
	    }
	
	
       public void reset(){
               this.setScore(0);
       }   
	       
	}