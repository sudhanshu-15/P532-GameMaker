package com.game.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpriteTest {
	
	private Sprite sprite = new Sprite();
	
	@Test
	public void testTheGetterAndSetter() {
		assertEquals("They are not equal", sprite.getHeight(), 0);
		
		assertEquals("They are not equal", sprite.getWidth(), 0);
		
		assertEquals("They are not equal", sprite.getPosition_X(), 500);
		
		assertEquals("They are not equal", sprite.getPosition_Y(), 500);
	
		assertEquals("They are not equal", sprite.getVel_X(), 10);
		
		assertEquals("They are not equal", sprite.getVel_Y(), 10);
		
		assertEquals("They are not equal", sprite.getActionInterface(), null);
	
		assertEquals("They are not equal", sprite.isHorizontal(), false);
		
		assertEquals("They are not equal", sprite.isVertical(), false);
		
		assertEquals("They are not equal", sprite.isRandom(), false);
		
		assertEquals("They are not equal", sprite.isCollidable(), false);
		
		assertEquals("They are not equal", sprite.isVisible(), true);
		
		assertEquals("They are not equal", sprite.getKeyCode(), 1000);
		
		assertEquals("They are not equal", sprite.isShooter(), false);
	}

}
