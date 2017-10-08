package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.game.model.GameModel;
import com.game.helpers.EventButtonListener;

public class EventButtonListenerTest {
		
	private GameModel gameModel = new GameModel();
	EventButtonListener EventButtonListener = new EventButtonListener(gameModel);
	ActionListener spy;
	ActionEvent e;
	private boolean horizontalMotion = false;
	private boolean verticalMotion = false;
	private boolean collision = false;
	
	@Before
	public void setUp() {
		String actionCommand = "Constants.SIDES";
		ActionEvent e = new ActionEvent(0, 0, actionCommand);
		spy = Mockito.spy(EventButtonListener);
		EventButtonListener.setHorizontalMotion(horizontalMotion);
		EventButtonListener.setVerticalMotion(verticalMotion);
		EventButtonListener.setCollision(collision);
	}
	
	@Test
	public void testActionPerformedUPDOWN() {
		String actionCommand = "Constants.UPDOWN";
		ActionEvent e = new ActionEvent(0, 0, actionCommand);
		spy.actionPerformed(e);
		Mockito.verify(spy, Mockito.times(1)).actionPerformed(e);
	}
	
}
