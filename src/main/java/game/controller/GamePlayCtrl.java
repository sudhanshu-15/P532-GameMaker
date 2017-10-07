package game.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import com.game.model.AutoSprite;
import com.game.model.CommandSprite;
import com.game.view.GameView;

import game.save.GameVariable;

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
