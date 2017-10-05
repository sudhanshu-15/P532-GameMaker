package game.controller;
/**
 * @author shubham
 * control the Auto sprite 
 * will continue to ask view to draw the updated value
 *
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;

import game.helper.Constants;
import game.model.AutoSprite;
import game.view.GameView;

public class AutoCtrl {
	GameView view;
	AutoSprite sprite;
	int location_X;
	int location_Y;
	int dirX;
	int dirY;
	int flagAuto;
	public AutoCtrl(GameView view, AutoSprite sprite) {
		super();
		this.view = view;
		this.sprite = sprite;
		this.dirX = 1;
		this.dirY = 1;
	}

	

	public int move() {
		 
		// XXX change logic to check if the sprite can move horizontal & vertical before actual move
		if (sprite.isHorizontalMove()) {
			location_X = sprite.getLocation_X() + dirX * Constants.MOVEMENT_AUTO_X;
			sprite.setLocation_X(location_X);
		}
		if (sprite.isVerticalMove()) {
			location_Y = sprite.getLocation_Y() + dirY * Constants.MOVEMENT_AUTO_Y;
			sprite.setLocation_Y(location_Y);
		}
		
		view.repaint();
		return flagAuto;
	}

	public void collision() {
		// Top & down collision
		if (sprite.canDispare() && !sprite.isDestroyed()) {	// if sprite can dispare and hasn't been destroyed yet
			sprite.setDestroyed(true);
		} else {
			dirY = -dirY;
			//Constants.MOVEMENT_AUTO_Y = -Constants.MOVEMENT_AUTO_Y;
		}
		
	}
	
	public void sideCollision() {
		// Side collision
		if (sprite.canDispare() && !sprite.isDestroyed()) {	// if sprite can dispare and hasn't been destroyed yet
			sprite.setDestroyed(true);
		} else {
			dirX = -dirX;
			//Constants.MOVEMENT_AUTO_X = -Constants.MOVEMENT_AUTO_X;
		}
	}
	
	public Rectangle getBound() {
		return new Rectangle(sprite.getLocation_X(), sprite.getLocation_Y(), sprite.getWidth(), sprite.getHeight());
	}
	
	public void draw(Graphics2D g2d, GameView gameView) {
		g2d.drawImage(sprite.getSpriteImage(), sprite.getLocation_X(), sprite.getLocation_Y(), sprite.getWidth(), sprite.getHeight(), gameView);
	}
	
	public boolean isDestroyed() {
		return sprite.isDestroyed();
	}

}
