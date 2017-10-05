package game.main;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.controller.AssignController;
import game.controller.AutoCtrl;
import game.controller.CommandCtrl;
import game.controller.CreateSprites;
import game.helper.BallVariable;
import game.helper.BrickVariable;
import game.helper.Constants;
import game.helper.GameVariable;
import game.helper.PaddleVariable;
import game.model.AutoSprite;
import game.model.CommandSprite;
import game.view.GameView;
import game.view.SelectPanel;


public class Main {

	public static void main(String[] args) {
		JFrame gameFrame = new JFrame();
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setTitle("Game maker");
		gameFrame.setSize(1400, 700);
		gameFrame.setResizable(false);
		gameFrame.setLayout(new GridLayout());
		GameView gameView = new GameView();
		SelectPanel selectPanel = new SelectPanel(gameView);
	gameFrame.add(selectPanel);
	StartGame start=new StartGame();	

	start.setGameView(gameView);
	selectPanel.setStartGame(start);
		gameFrame.add(gameView);
		selectPanel.setSize(700, 700);
		
		//System.out.println(gameView.toString()+"1");
		//gameFrame.pack();
		gameFrame.setVisible(true);

		
	}
	
	

}
