package com.game.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.game.model.GameModel;
import com.game.model.Sprite;

public class GamePlayPanel extends JPanel {
	
	private GameModel gameModel;
	
	private static Logger gamePlayPanelLog = Logger.getLogger("gamePlayPanelLogger");
	
	
	public GamePlayPanel(GameModel gameModel){
		this.gameModel = gameModel;
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		try{
			for(Sprite sprite : gameModel.getSpriteList()){
				if(sprite.isVisible()){
					sprite.draw(g);
				}
			}
		}catch(NullPointerException e){
			gamePlayPanelLog.error("Failed to get array " + e.getLocalizedMessage());
		}
	}

}
