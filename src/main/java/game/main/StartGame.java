package game.main;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.controller.AssignController;
import game.controller.AutoCtrl;
import game.controller.CommandCtrl;
import game.controller.CreateSprites;
import game.helper.BallVariable;
import game.helper.BrickVariable;
import game.helper.GameVariable;
import game.helper.PaddleVariable;
import game.model.AutoSprite;
import game.model.CommandSprite;
import game.view.GameView;
import game.view.SelectPanel;

public class StartGame {

	private GameView gameView;
private GameVariable gameVariable;
	
	public GameVariable getGameVariable() {
		return gameVariable;
	}

	public void setGameVariable(GameVariable gameVariable) {
		this.gameVariable = gameVariable;
	}	
	public GameView getGameView() {
		return gameView;
	}

	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}

	public void start(){
	
	   
	
		  CreateSprites create = new CreateSprites();
	
	   create.create(gameVariable);
		
		// XXX POC-multiple sprites
		List<AutoSprite> autoSpriteList = create.createAutoSprite();
    	 
		List<CommandSprite> commandSpriteList = create.createCommandSprite();
	
		//commandSpriteList.add(paddle1);
		
		//System.out.println(autoSpriteList.size());
		
		
		AssignController assignCtrl = new AssignController(gameView);
		List<AutoCtrl> autoCtrlList = assignCtrl.assignAutoCtrl(autoSpriteList);
		List<CommandCtrl> commandCtrlList = assignCtrl.assignCommandCtrl(commandSpriteList);
		
		
		gameView.setAutoCtrl(autoCtrlList);
		gameView.setCommandCtrl(commandCtrlList);
		

		
	
		gameView.display();	  
	
        
		
		
		
		
		
		
		
		
	 
	}
}
