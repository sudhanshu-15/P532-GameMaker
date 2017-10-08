package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.game.model.TimerReadout;

public class ReadoutButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(Constants.CLOCK))
		{
			TimerReadout.isTimerSet = true;
		}
	}

}
