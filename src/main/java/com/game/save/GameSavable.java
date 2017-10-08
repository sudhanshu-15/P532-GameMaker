package com.game.save;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.game.strategy.Music;

public class GameSavable implements Serializable {
	
	private static final long serialVersionUID = 027;
	
	public ArrayList spriteList;
	public ImageIcon background;
	public Music music;
	
	public GameSavable(ArrayList spriteList, ImageIcon background, Music music) {
		this.spriteList = spriteList;
		this.background = background;
		this.music = music;
	}
	
}
