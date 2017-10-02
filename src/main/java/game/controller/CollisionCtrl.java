package game.controller;

import java.awt.Rectangle;

public class CollisionCtrl {

	public CollisionCtrl() {
	}

	public void checkCollision(AutoCtrl ac, CommandCtrl cc) {
		Rectangle intersection = ac.getBound().intersection(cc.getBound());
		if (!intersection.isEmpty()) {
			if (ac.getBound().getMinX() < intersection.getMinX()
					&& ac.getBound().getCenterX() < intersection.getMinX()) {
				ac.sprite.setLocation_X((int) (ac.location_X - intersection.getWidth()));
				ac.sideCollision();
			} else if (ac.getBound().getMaxX() > intersection.getMaxX()
					&& ac.getBound().getCenterX() > intersection.getMaxX()) {
				ac.sprite.setLocation_X((int) (ac.location_X + intersection.getWidth()));
				ac.sideCollision();
			} else if (ac.getBound().getMinY() < intersection.getMinY()
					&& ac.getBound().getCenterY() < intersection.getMinY()) {
				ac.sprite.setLocation_Y((int) (ac.location_Y - intersection.getHeight()));
				ac.collision();
			} else if (ac.getBound().getMaxY() > intersection.getMaxY()
					&& ac.getBound().getCenterY() > intersection.getMaxY()) {
				ac.sprite.setLocation_Y((int) (ac.location_Y + intersection.getHeight()));
				ac.collision();
			}
		}
	}

	public void checkCollision(AutoCtrl ac1, AutoCtrl ac2) {
		Rectangle intersection = ac1.getBound().intersection(ac2.getBound());
		if (!intersection.isEmpty()) {
			if (ac1.getBound().getMinX() < intersection.getMinX()
					&& ac1.getBound().getCenterX() < intersection.getMinX()) {
				ac1.sideCollision();
				ac2.sideCollision();
			}
			if (ac1.getBound().getMaxX() > intersection.getMaxX()
					&& ac1.getBound().getCenterX() > intersection.getMaxX()) {
				ac1.sideCollision();
				ac2.sideCollision();
			}
			if (ac1.getBound().getMinY() < intersection.getMinY()
					&& ac1.getBound().getCenterY() < intersection.getMinY()) {
				ac1.collision();
				ac2.collision();
			}
			if (ac1.getBound().getMaxY() > intersection.getMaxY()
					&& ac1.getBound().getCenterY() > intersection.getMaxY()) {
				ac1.collision();
				ac2.collision();
			}
		}
	}

	public void checkCollision(CommandCtrl cc1, CommandCtrl cc2) {

	}

}
