/**
 * 
 */
package com.game.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.Timer;

import com.game.controller.AssignController;
import com.game.controller.AutoCtrl;
import com.game.controller.CollisionCtrl;
import com.game.controller.CommandCtrl;
import com.game.controller.CreateSprites;
import com.game.helpers.Constants;
import com.game.model.AutoSprite;
import com.game.model.CommandSprite;

import game.save.GameVariable;

/**
 * @author shubham it will be the view that will capture movement and request
 *         controller for data to display on screen
 */
@SuppressWarnings("serial")
public class GameView extends Panel {

	private List<AutoCtrl> autoCtrlList;
	private List<CommandCtrl> commandCtrlList;

	public void setCommandCtrl(List<CommandCtrl> commandCtrlList) {
		this.commandCtrlList = commandCtrlList;
	}

	public void setAutoCtrl(List<AutoCtrl> autoCtrlList) {
		//System.out.println(autoCtrlList.size()+"here");
		this.autoCtrlList = autoCtrlList;
	}

	// the actual method that will paint the game objects on the screen
	@Override
	public void paint(Graphics g) {

		super.paint(g);
		this.requestFocus();
		Graphics2D g2d = (Graphics2D) g;
		// XXX put draw method into Controller
		
		if(autoCtrlList!=null && commandCtrlList!=null)
		{	
		for (AutoCtrl ac : autoCtrlList) {
			if (!ac.isDestroyed()) {
				ac.draw(g2d, this);
			}
		}
		for (CommandCtrl cc : commandCtrlList) {
			cc.draw(g2d, this);
		}
		
		}
	}

	public void display() {
		repaint();
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// XXX apply changes for multiple controller
				for (AutoCtrl ac : autoCtrlList) {
					ac.move();
				}
				
				CollisionCtrl collisionCtrl = new CollisionCtrl();
				for (AutoCtrl ac : autoCtrlList) {
					for (CommandCtrl cc : commandCtrlList) {
						// Check collision between every autoCtrl & commandCtrl
						collisionCtrl.checkCollision(ac, cc);
					}
					// Check collision between auto sprites and board
					// right & left boarder collision
					if (ac.getBound().getMaxX() >= Constants.PANEL_WIDTH || ac.getBound().getMinX() <= 0) {
						ac.sideCollision();
					}
					// bottom & top boarder collision
					if (ac.getBound().getMaxY() >= Constants.PANEL_HEIGTH || ac.getBound().getMinY() <=0) {
						ac.collision();
					}
				}
				
				for (AutoCtrl ac1 : autoCtrlList) {
					for (AutoCtrl ac2 : autoCtrlList) {
						collisionCtrl.checkCollision(ac1, ac2);
					}
				}
				
				
				
				
			}
		};

		Timer timer = new Timer(100, actionListener);
		timer.start();
		KeyListener keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				for (CommandCtrl cc : commandCtrlList) {
					cc.move(e);
				}

			}
		};
		this.addKeyListener(keyListener);

	}
	
//	public void passGameVariabl(GameVariable gv) {
//		CreateSprites cs = new CreateSprites();
//		cs.create(gv);
//		List<AutoSprite> ac = cs.createAutoSprite();
//		List<CommandSprite> cc = cs.createCommandSprite();
//		AssignController assignCtrl = new AssignController(this);
//		assignCtrl.assignCommandCtrl(cc);
//		setAutoCtrl(assignCtrl.assignAutoCtrl(ac));
//		setCommandCtrl(assignCtrl.assignCommandCtrl(cc));
//		repaint();
//	}

	

}
