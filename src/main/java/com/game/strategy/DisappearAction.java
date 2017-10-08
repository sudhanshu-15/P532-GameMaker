package com.game.strategy;

import java.awt.Rectangle;
import java.io.Serializable;

import com.game.model.GameModel;
import com.game.model.Sprite;

public class DisappearAction implements ActionInterface, Serializable {
	
	private static final long serialVersionUID = 4L;
	
	private GameModel gameModel;
	
	public DisappearAction(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void performAction(Sprite gameSprite) {
		
		if(gameSprite.isCollidable() && gameSprite.isVisible()){
			
			Rectangle currentSpriteCollider = gameSprite.createCollider();
			
			for (Sprite listSprite : gameModel.getSpriteList()){
				
				Rectangle listSpriteCollider = listSprite.createCollider();
				
				if(listSpriteCollider.intersects(currentSpriteCollider) && !listSprite.equals(gameSprite)){
					//TODO Logic for changing Velocity?

					gameSprite.setVisible(false);
					if(listSprite.isProjectile()){
						listSprite.setVisible(false);
					}
					
					//Logic for Sound effect
				}
				
			}
			
		}

	}

}
