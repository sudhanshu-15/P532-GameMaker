package game.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import game.helper.GameVariable;
import game.model.AutoSprite;
import game.model.CommandSprite;
import game.view.GameView;

public class GamePlayCtrl {
	GameView gameView;
	
	public GamePlayCtrl() {
		initGameView();
	}

	private void initGameView() {
		
		List<AutoSprite> autoSpriteList = new LinkedList<>();
		List<CommandSprite> commandSpriteList = new LinkedList<>();
		gameView.display();
	}
		
}
