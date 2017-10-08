package com.game.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.game.helpers.Constants;
import com.game.model.GameModel;
import com.game.model.Sprite;

@SuppressWarnings("serial")
public class GamePlayPanel extends JPanel {
	
	private GameModel gameModel;
	
	private static Logger gamePlayPanelLog = Logger.getLogger("gamePlayPanelLogger");
	private Image backGroundImage;
	
	public GamePlayPanel(GameModel gameModel){
		this.setSize(Constants.GAME_PANEL_DIMENSION);
		this.gameModel = gameModel;
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setFocusTraversalKeysEnabled(false);
		backGroundImage = this.getBackGroundImage();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.drawImage(backGroundImage, 0, 0, this.getWidth(), this.getHeight(), this);	
		
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

	public Image getBackGroundImage() {
		return backGroundImage;
	}

	public void setBackGroundImage(Image backGroundImage) {
		this.backGroundImage = backGroundImage;
		
	}

	

}
