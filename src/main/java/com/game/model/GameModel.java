package com.game.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GameModel implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	private Sprite gameSprite;
	private ArrayList<Sprite> spriteList;
	private ImageIcon backgroundImage;
	
	public GameModel(){
		this.gameSprite = new Sprite();
		this.spriteList = new ArrayList<Sprite>();
	}
	
	private void addSprite(){
		spriteList.add(new Sprite(gameSprite));
	}
	
	private void removeSprite(Sprite sprite){
		int i = spriteList.indexOf(sprite);
		if(i >= 0){
			spriteList.remove(i);
		}
	}

	public Sprite getGameSprite() {
		return gameSprite;
	}

	public void setGameSprite(Sprite gameSprite) {
		this.gameSprite = gameSprite;
	}

	public ArrayList<Sprite> getSpriteList() {
		return spriteList;
	}

	public void setSpriteList(ArrayList<Sprite> spriteList) {
		this.spriteList = spriteList;
	}

	public ImageIcon getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(ImageIcon backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
}