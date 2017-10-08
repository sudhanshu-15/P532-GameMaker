package com.game.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import com.game.helpers.Constants;

public class TimerReadout implements ActionListener
{
	private Timer timer;
	public static int timerSeconds = 0;
	public static int timerMinutes = 0;
	public static boolean isTimerSet = false;
	
	public TimerReadout()
	{
		timer = new Timer(1000, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timerSeconds++;
		
		if(timerSeconds == 59)
		{
			timerMinutes++;
			timerSeconds = 0;
		}	
	}
	
	public void startTimer()
	{
		this.timer.start();
	}

	public void stopTimer()
	{
		this.timer.stop();
	}
	
	public static void draw(Graphics g)
	{
		g.setFont(new Font(Font.SERIF, Font.BOLD, 24));
		g.setColor(Color.RED);
		g.drawString(timerMinutes + " : " + timerSeconds, Constants.GAME_PANEL_WIDTH-70, 20);
	}

}

