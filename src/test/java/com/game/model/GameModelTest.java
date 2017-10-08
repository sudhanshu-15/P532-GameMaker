package com.game.model;

import static org.junit.Assert.*;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

public class GameModelTest {
	
	private GameModel gameModel = new GameModel();
	private Sprite gameSprite = gameModel.getGameSprite();
	private ArrayList<Sprite> spriteList = gameModel.getSpriteList();
	private Image backgroundImage = gameModel.getBackgroundImage();
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetterAndSetter() {
	
		assertEquals("They are not equal", gameModel.getGameSprite(), gameSprite);
	
		assertEquals("They are not equal", gameModel.getSpriteList(), spriteList);
		
		assertEquals("They are not equal", gameModel.getBackgroundImage(), backgroundImage);
	}

}
