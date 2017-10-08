package com.game.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameModelTest {
	
	private GameModel gameModel = new GameModel();
	private Sprite gameSprite = gameModel.getGameSprite();

	@Before
	public void setUp() {
		
	}
	@Test
	public void testGetterAndSetter() {
		assertEquals("They are not equal", gameModel.getGameSprite(), gameSprite);
	}

}
