package game.save;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class PaddleVariable implements Serializable {
	private int location_X;
	private int location_Y;
	private int paddleImageIndex;
	
	public int getPaddleImageIndex() {	
		return paddleImageIndex;
	}

	public void setPaddleImageIndex(int index) {
		this.paddleImageIndex = index;
	}

	private Image paddleImage;
	private boolean ifMove;
	private boolean moveLeft;
	private boolean moveRight;
	private boolean moveUp;
	private boolean moveDown;

	public boolean isIfMove() {
		return ifMove;
	}

	public void setIfMove(boolean ifMove) {
		this.ifMove = ifMove;
	}

	public int getLocation_X() {
		return location_X;
	}

	public void setLocation_X(int location_X) {
		this.location_X = location_X;
	}

	public int getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(int location_Y) {
		this.location_Y = location_Y;
	}

	public Image getPaddleImage() {
		setPaddleImage();
		return paddleImage;
	}

	public void setPaddleImage() {
		int paddleImageIndex = this.getPaddleImageIndex();
		if(paddleImageIndex == 1) {
			this.paddleImage = new ImageIcon(this.getClass().getClassLoader().getResource("paddle1.jpg")).getImage();
		}
		else {
			this.paddleImage = new ImageIcon(this.getClass().getClassLoader().getResource("paddle2.jpg")).getImage();
		}
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
