package com.game.controller;

import org.apache.log4j.Logger;

import com.game.helpers.EventButtonListener;
import com.game.helpers.ImageButtonListener;
import com.game.model.GameModel;
import com.game.model.Sprite;
import com.game.view.GameMakerPanel;
import com.game.view.GamePlayPanel;

public class GameController {
	
	private GameMakerPanel gameMakerPanel;
	private GamePlayPanel gamePlayPanel;
	private GameModel gameModel;
	
	private boolean gamePlay = false;
	
	private static Logger gameControlLog = Logger.getLogger("gameControlLogger");
	
	public GameController(GameModel gameModel, GameMakerPanel gameMakerPanel, GamePlayPanel gamePlayPanel) {
		this.gameModel = gameModel;
		this.gameMakerPanel = gameMakerPanel;
		this.gamePlayPanel = gamePlayPanel;
		this.gameMakerPanel.addImageButtonListener(new ImageButtonListener(gameModel, gameMakerPanel));
		this.gameMakerPanel.addEventButtonListener(new EventButtonListener(gameModel));
	}
	
	public void gameLoop(){
		new Thread() {
			public void run(){
				while(true){
					if(gamePlay){
						for(Sprite sprite : gameModel.getSpriteList()){
							//TODO Add logic for command
							gamePlayPanel.repaint();
						}
					}
					try {
						java.lang.Thread.sleep(30);
					} catch (InterruptedException e) {
						gameControlLog.error("Error in thread" + e.getLocalizedMessage());
					}
				}
			}
		}.start();
	}

	public GameMakerPanel getGameMakerPanel() {
		return gameMakerPanel;
	}

	public void setGameMakerPanel(GameMakerPanel gameMakerPanel) {
		this.gameMakerPanel = gameMakerPanel;
	}

	public GamePlayPanel getGamePlayPanel() {
		return gamePlayPanel;
	}

	public void setGamePlayPanel(GamePlayPanel gamePlayPanel) {
		this.gamePlayPanel = gamePlayPanel;
	}

	public GameModel getGameModel() {
		return gameModel;
	}

	public void setGameModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	public boolean isGamePlay() {
		return gamePlay;
	}

	public void setGamePlay(boolean gamePlay) {
		this.gamePlay = gamePlay;
	}
		
}
