package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.game.model.GameModel;
import com.game.model.TimerReadout;

public class ReadoutButtonListener implements ActionListener {

	TimerReadout timerReadout;
	
	public ReadoutButtonListener(GameModel gameModel) {
		this.timerReadout = gameModel.getTimerReadout();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(Constants.CLOCK))
		{
			timerReadout.isTimerSet = true;
		}
	}

}
