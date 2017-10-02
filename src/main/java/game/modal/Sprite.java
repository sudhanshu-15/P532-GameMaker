/**
 * 
 */
package game.modal;

import java.awt.Image;

/**
 * @author shubham
 *the parent sprite it will have the variables and business logic common to all sprite
 */
public class Sprite {
	   
    // all sprites going to have a location on the screen
	private int location_X;
	private int location_Y;
	// all sprites are going to have an image
	private Image spriteImage;
	// all sprites are going to have a dimensions
	private int height;
	private int width;

	  
	
	public Sprite(int location_X, int location_Y, Image spriteImage, int height, int width) {
		super();
		this.location_X = location_X;
		this.location_Y = location_Y;
		this.spriteImage = spriteImage;
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
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

	public Image getSpriteImage() {
		return spriteImage;
	}

	public void setSpriteImage(Image spriteImage) {
		this.spriteImage = spriteImage;
	}
  
}
