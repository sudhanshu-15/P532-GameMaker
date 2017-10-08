package com.game.save;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.model.GameModel;

public class GameSavable implements Serializable {
	
	private static final long serialVersionUID = 027;
	
	public ArrayList spriteList;
	public ImageIcon imageIcon;
	
	public GameSavable(GameModel gameModel) {
		this.spriteList = gameModel.getSpriteList();
		this.imageIcon = new ImageIcon(gameModel.getBackgroundImage());	
	}
	
}
