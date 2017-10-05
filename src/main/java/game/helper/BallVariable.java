package game.helper;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class BallVariable implements Serializable{
	private int location_X;
	private int location_Y;
	private int ballImageIndex;


	private Image ballImage;
	private boolean moveVertical;
	private boolean moveHorizontal;
	
	public int getBallImageIndex() {
		return ballImageIndex;
	}

	public void setBallImageIndex(int ballImageIndex) {
		this.ballImageIndex = ballImageIndex;
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

	public Image getBallImage() {
		setBallImage();
		return ballImage;
	}

	public void setBallImage() {
		if(this.getBallImageIndex() == 1) {
			this.ballImage = new ImageIcon(this.getClass().getClassLoader().getResource("ball1.png")).getImage();
		}
		else {
			this.ballImage = new ImageIcon(this.getClass().getClassLoader().getResource("ball2.png")).getImage();
		}
		
	}

	public boolean isMoveHorizontal() {
		return moveHorizontal;
	}

	public void setMoveHorizontal(boolean moveHorizontal) {
		this.moveHorizontal = moveHorizontal;
	}

	public boolean isMoveVertical() {
		return moveVertical;
	}

	public void setMoveVertical(boolean moveVertical) {
		this.moveVertical = moveVertical;
	}

}
