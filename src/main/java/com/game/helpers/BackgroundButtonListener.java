package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.game.controller.GameController;
import com.game.view.GamePlayPanel;

public class BackgroundButtonListener implements ActionListener {
	
	private GameController gameController;
	private GamePlayPanel gamePlayPanel;
	
	public BackgroundButtonListener(GameController gameController){
		this.gameController = gameController;
		this.gamePlayPanel = gameController.getGamePlayPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
