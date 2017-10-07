package com.game.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSplitPane;


import com.game.controller.GameController;
import com.game.helpers.Constants;
import com.game.model.GameModel;




@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	
	private GameMakerPanel gameMakerPanel;
	private GamePlayPanel gamePlayPanel;
	private GameModel gameModel;
	private GameController gameControl;
	
	public GameFrame(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(Constants.GAMEFRAME_TITLE);
		this.setSize(Constants.GAMEFRAME_WIDTH, Constants.GAMEFRAME_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		gameMakerPanel = new GameMakerPanel();
		gameModel = new GameModel();
		gamePlayPanel = new GamePlayPanel(gameModel);
		gameControl = new GameController(gameModel, gameMakerPanel, gamePlayPanel);
		
		JSplitPane splitPane = new JSplitPane();
	    splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gameMakerPanel, gamePlayPanel);
		splitPane.setDividerLocation(Constants.SPLITPANE_LOCATION);
		splitPane.setDividerSize(Constants.SPLITPANE_SIZE);
		splitPane.setBackground(Color.BLACK);
		this.add(splitPane);
		this.setVisible(true);	
	}
}
