package com.game.save;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

public class GameSavable implements Serializable {
	
	private static final long serialVersionUID = 027;
	
	public ArrayList spriteList;
	public Image background;
	
	public GameSavable(ArrayList spriteList, Image background) {
		this.spriteList = spriteList;
		this.background = background;
	}
	
}
