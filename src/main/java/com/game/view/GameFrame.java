package com.game.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import com.game.helper.Constants;



@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	
	private GameMakerPanel gameMakerPanel;
	private GamePlayPanel gamePlayPanel;
	public GameFrame(){
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle(Constants.GAMEFRAME_TITLE);
	this.setSize(Constants.GAMEFRAME_WIDTH, Constants.GAMEFRAME_HEIGHT);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	gameMakerPanel = new GameMakerPanel();
	gamePlayPanel = new GamePlayPanel();
	
		JSplitPane splitPane = new JSplitPane();
    	splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gameMakerPanel, gamePlayPanel);
		splitPane.setDividerLocation(Constants.SPLITPANE_LOCATION);
		splitPane.setDividerSize(Constants.SPLITPANE_SIZE);
		splitPane.setBackground(Color.BLACK);
		this.add(splitPane);

	

	this.setVisible(true);	
	}
}
