/**
 * 
 */
package game.controller;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.game.helpers.Constants;
import com.game.model.CommandSprite;

import game.view.GameView;

/**
 * @author shubham control the command sprite view read user input and when
 *         event occurs it will update the value and ask view to draw it
 *
 */
public class CommandCtrl {
	GameView view;
	CommandSprite sprite;
	int location_X;
	int location_Y;

	public CommandCtrl(GameView view, CommandSprite sprite) {
		super();
		this.view = view;
		this.sprite = sprite;
	}



	public void move(KeyEvent keyEvent) {

		int keyCode = keyEvent.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (sprite.isMoveUp() == true) {
				location_Y = sprite.getLocation_Y() - Constants.MOVE_PLAYER_Y;
				sprite.setLocation_Y(location_Y);
			}
			
			
			break;
		case KeyEvent.VK_DOWN:
			if (sprite.isMoveDown() == true) {
				location_Y = sprite.getLocation_Y() + Constants.MOVE_PLAYER_Y;
				sprite.setLocation_Y(location_Y);
			}
			
			
			break;
		case KeyEvent.VK_LEFT:
			if (sprite.isMoveLeft() == true) {
				location_X = sprite.getPosition_X() - Constants.MOVE_PLAYER_X;
				sprite.setLocation_X(location_X);
			}
			
			
			break;
		case KeyEvent.VK_RIGHT:
			if (sprite.isMoveRight() == true) {
				location_X = sprite.getPosition_X() + Constants.MOVE_PLAYER_X;
				sprite.setLocation_X(location_X);
			}
			
			
			break;
		}

	}
	
	public Rectangle getBound() {
		return new Rectangle(sprite.getPosition_X(), sprite.getLocation_Y(), sprite.getWidth(), sprite.getHeight());
	}
	
	public void draw(Graphics2D g2d, GameView gameView) {
		g2d.drawImage(sprite.getSpriteImage(), sprite.getPosition_X(), sprite.getLocation_Y(), sprite.getWidth(), sprite.getHeight(), gameView);
	}
}
