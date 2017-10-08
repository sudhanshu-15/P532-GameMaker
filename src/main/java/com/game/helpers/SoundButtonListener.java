package com.game.helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import org.apache.log4j.Logger;

import com.game.strategy.Music;

import javazoom.jl.player.Player;

public class SoundButtonListener implements ActionListener, Serializable {
	private Player player;
	String fileName;

	private static Logger backgroundMusicRbLog = Logger.getLogger("backgroundMusicRbLogger");

	Music music = new Music();

	@Override
	public void actionPerformed(ActionEvent e) {
		String commandString = e.getActionCommand();
		switch (commandString) {
		case Constants.MARIOMUSIC:
			fileName = "sound/mario.mp3";
			stopMusic();
			playMusic(fileName);
			break;
		case Constants.TICKTOCK:
			fileName = "sound/Tick.mp3";
			stopMusic();
			playMusic(fileName);
			break;
		case Constants.NOMUSIC:
			stopMusic();
			break;
		}
	}

	private void playMusic(String fileName) {
		music.play(fileName);
	}

	private void stopMusic() {
		music.stop();
	}

}

