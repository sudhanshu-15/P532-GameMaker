package game_maker.main;



import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import java.awt.Image;

import game.controller.AutoCtrl;
import game.model.AutoSprite;
import game.view.GameView;
import game.view.SelectPanel;

public class Test {

	int location_X, location_Y, height, width;
	Image spriteImage;  
	boolean horizontalMove, verticalMove, dispare, destroyed;
	
		GameView gameView = new GameView();
		AutoSprite autoSprite = new AutoSprite( location_X,  location_Y,  spriteImage,  height,  width,  horizontalMove,
				 verticalMove,  dispare,  destroyed);
		AutoCtrl autoCtrl = new AutoCtrl(gameView, autoSprite);
		SelectPanel selectPanel = new SelectPanel(gameView);
		
	
	
	public void testAutoCheck() {
		
		assertEquals( 1, autoCtrl.move());
		
	}
	
	public void testSelectSprite(){
		
		assertEquals("Check if true", 1, selectPanel.addSprite());
	
	}
	public void testVisible(){
		
		selectPanel.hideAllPanels();
		assertEquals("Visibility check", false, selectPanel.ballPanel.isVisible());
	
	}
	public void testSelectFeature(){
		
		assertEquals("Feature check", 1,selectPanel.addBallToList());
	}
	
}