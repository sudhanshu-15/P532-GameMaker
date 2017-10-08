package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

import com.game.controller.GameController;
import com.game.model.GameModel;
import com.game.view.GamePlayPanel;

public class GameButtonListener implements ActionListener {
	
	private GameController gameController;
	private GameModel gameModel;
	private GamePlayPanel gamePlayPanel;
	
	private static Logger buttonLog = Logger.getLogger("buttonLogger");
	
	public GameButtonListener(GameController gameController){
		this.gameController = gameController;
		this.gameModel = gameController.getGameModel();
		this.gamePlayPanel = gameController.getGamePlayPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		switch(actionCommand){
		case Constants.DRAW:
			buttonLog.info("Draw button clicked");
			gameModel.addSprite();
			gamePlayPanel.repaint();
			break;
		case Constants.PLAY:
			buttonLog.info("Play button clicked");
			gamePlayPanel.repaint();
			gameController.setGamePlay(true);
			break;
		case Constants.PAUSE:
			buttonLog.info("Pause button clicked");
			gameController.setGamePlay(false);
			break;
		case Constants.SAVE:
			buttonLog.info("Save button clicked");
			performSave();
			break;
		case Constants.LOAD:
			buttonLog.info("Load button clicked");
			performLoad();
			break;
		}

	}
	
	public void performSave(){
		//TODO Write code to handle save
	}
	
	public void performLoad(){
		//TODO Write code to handle load
	}

}
