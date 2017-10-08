package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.game.controller.GameController;
import com.game.model.GameModel;
import com.game.model.TimerReadout;
import com.game.save.GameLoad;
import com.game.save.GameSavable;
import com.game.save.GameSave;
import com.game.view.GamePlayPanel;

public class GameButtonListener implements ActionListener {
	
	private GameController gameController;
	private GameModel gameModel;
	private GamePlayPanel gamePlayPanel;
	private TimerReadout timerReadout;
	
	private static Logger buttonLog = Logger.getLogger("buttonLogger");
	
	public GameButtonListener(GameController gameController){
		this.gameController = gameController;
		this.gameModel = gameController.getGameModel();
		this.gamePlayPanel = gameController.getGamePlayPanel();
		this.timerReadout = new TimerReadout();
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
			
			if(TimerReadout.isTimerSet)
			{
				timerReadout.startTimer();
			}
			break;
		case Constants.PAUSE:
			buttonLog.info("Pause button clicked");
			gameController.setGamePlay(false);
			
			if(TimerReadout.isTimerSet)
			{
				timerReadout.stopTimer();
			}
						
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
		GameSave gameSave = new GameSave(gameModel);
		if(gameSave.serialize()){
			JOptionPane.showMessageDialog(null,
					"Save Successful",
					"Save",
					JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null,
					"Error Saving File",
					"Save",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void performLoad(){
		GameLoad gameLoad = new GameLoad();
		try {
			GameSavable loadSavable = gameLoad.deserialize();
			gameController.getGameModel().setSpriteList(loadSavable.spriteList);
			gameController.getGameModel().setBackgroundImage(loadSavable.imageIcon.getImage());
			gamePlayPanel.setBackGroundImage(loadSavable.imageIcon.getImage());
			gamePlayPanel.repaint();
			
		}catch(Exception e){
			buttonLog.error("Loading Failed" + e.getLocalizedMessage());
		}
		
	}

}
