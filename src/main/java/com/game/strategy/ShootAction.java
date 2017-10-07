package com.game.strategy;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import com.game.helpers.Constants;
import com.game.model.GameModel;
import com.game.model.Sprite;

public class ShootAction implements ActionInterface, Serializable {
	
	private GameModel gameModel;
	
	public ShootAction(GameModel gameModel){
		this.gameModel = gameModel;
	}

	@Override
	public void performAction(Sprite gameSprite) {
		if(gameSprite.isShooter()){
			Sprite projectile = createProjectile(gameSprite.getPosition_X(), gameSprite.getPosition_Y());
			projectile.setActionInterface(new AutomoveAction(gameModel));
			gameModel.getSpriteList().add(projectile);
			// TODO Decide on 2 different arrayList for Game
		}
	}
	
	private Sprite createProjectile(int posX, int posY){
		Sprite projectileSprite = new Sprite();
		ImageIcon rocketIcon = new ImageIcon("resources/rocket.png");
		Image tempImage = rocketIcon.getImage();
		tempImage = tempImage.getScaledInstance(Constants.DEFAULT_ROCKETSIZE, Constants.DEFAULT_ROCKETSIZE, java.awt.Image.SCALE_SMOOTH);
		rocketIcon.setImage(tempImage);
		projectileSprite.setSpriteImage(rocketIcon);
		projectileSprite.setCollidable(true);
		projectileSprite.setVertical(true);
		projectileSprite.setVel_Y(Constants.DEFAULT_ROCKET_SPEED);
		projectileSprite.setPosition_X(posX);
		projectileSprite.setPosition_Y(posY + 5);
		return projectileSprite;
	}

}
