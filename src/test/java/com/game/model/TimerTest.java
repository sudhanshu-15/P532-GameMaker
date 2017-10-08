package com.game.model;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TimerTest {
	
	private TimerReadout TimerReadout = new TimerReadout();
	public static int timerSeconds = 0;
	public static int timerMinutes = 0;
	
	
	@Test
	public void testTimer() {
		TimerReadout.startTimer();
		assertEquals(timerMinutes, TimerReadout.timerMinutes);
		TimerReadout.stopTimer();
	}

}
