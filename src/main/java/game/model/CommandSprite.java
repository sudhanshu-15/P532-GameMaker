/**
 * 
 */
package game.model;

import java.awt.Image;

/**
 * @author shubham
 * This sprite will take input from the user to move on the screen
 *
 */
public class CommandSprite extends Sprite{

	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;
	
	public CommandSprite(int location_X, int location_Y, Image spriteImage, int height, int width, boolean moveLeft, boolean moveRight,
			boolean moveUp, boolean moveDown) {
		super(location_X, location_Y, spriteImage,height,width);
		this.moveLeft = moveLeft;
		this.moveRight = moveRight;
		this.moveUp = moveUp;
		this.moveDown = moveDown;
	}

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isMoveDown() {
		return moveDown;
	}

	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}
}
