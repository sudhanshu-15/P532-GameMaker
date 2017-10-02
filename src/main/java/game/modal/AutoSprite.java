package game.modal;

import java.awt.Image;

/**
 * @author shubham sprite for the game objects that going move themselves
 *         without gamer's involvement It should allow the user the choice how
 *         they want want it to move
 */
public class AutoSprite extends Sprite {
	private boolean horizontalMove;
	private boolean verticalMove;
	private boolean dispare; // Dispare or not
	private boolean destroyed;

	public AutoSprite(int location_X, int location_Y, Image spriteImage, int height, int width, boolean horizontalMove,
			boolean verticalMove, boolean dispare, boolean destroyed) {
		super(location_X, location_Y, spriteImage, height, width);
		this.horizontalMove = horizontalMove;
		this.verticalMove = verticalMove;
		this.dispare = dispare;
		this.destroyed = destroyed;
	}

	public boolean isHorizontalMove() {
		return horizontalMove;
	}

	public void setHorizontalMove(boolean horizontalMove) {
		this.horizontalMove = horizontalMove;
	}

	public boolean isVerticalMove() {
		return verticalMove;
	}

	public void setVerticalMove(boolean verticalMove) {
		this.verticalMove = verticalMove;
	}
	
	public boolean canDispare() {
		return dispare;
	}
	
	public void setDispare(boolean value) {
		this.dispare = value;
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	
	public void setDestroyed(boolean value) {
		destroyed = value;
	}
}
