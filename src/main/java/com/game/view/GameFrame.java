package com.game.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import com.game.helpers.Constants;



@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	
	private GameMakerPanel gameMakerPanel;
	private GamePlayPanel gamePlayPanel;
	private JScrollPane scrollPane;
	public GameFrame(){
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setTitle(Constants.GAMEFRAME_TITLE);
	this.setSize(Constants.GAMEFRAME_WIDTH, Constants.GAMEFRAME_HEIGHT);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	gameMakerPanel = new GameMakerPanel();
	scrollPane = new JScrollPane(gameMakerPanel);
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	
	gamePlayPanel = new GamePlayPanel();
	
		JSplitPane splitPane = new JSplitPane();
    	splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, gamePlayPanel);
		splitPane.setDividerLocation(Constants.SPLITPANE_LOCATION);
		splitPane.setDividerSize(Constants.SPLITPANE_SIZE);
		splitPane.setBackground(Color.BLACK);
		

	
		this.add(splitPane);

	

	this.setVisible(true);	
	}
}
