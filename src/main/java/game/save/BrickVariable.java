package game.save;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class BrickVariable implements Serializable{
	private int location_X;
	private int location_Y;
	private int brickImageIndex;
	
	public int getBrickImageIndex() {
		return brickImageIndex;
	}
	public void setBrickImageIndex(int brickImageIndex) {
		this.brickImageIndex = brickImageIndex;
	}
	private Image brickImage;
	private boolean disappear;
	
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
	public Image getBrickImage() {
		setBrickImage();
		return brickImage;
	}
	public void setBrickImage() {
		if(this.brickImageIndex == 1) {
			this.brickImage = new ImageIcon(this.getClass().getClassLoader().getResource("brick1.jpg")).getImage();
		}
		else {
			this.brickImage = new ImageIcon(this.getClass().getClassLoader().getResource("brick2.jpg")).getImage();
		}
	}
	public boolean isDisappear() {
		return disappear;
	}
	public void setDisappear(boolean disappear) {
		this.disappear = disappear;
	}
}
