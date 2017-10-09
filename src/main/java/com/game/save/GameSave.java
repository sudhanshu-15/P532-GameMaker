package com.game.save;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import com.game.controller.GameController;
import com.game.model.GameModel;
import com.game.model.Sprite;
import com.game.strategy.Music;

public class GameSave{

	private ArrayList<Sprite> spriteList;
	private Image background;
	public GameSavable gameSavable;
	private GameModel gameModel;
	private Music music;

	public GameSave(GameModel gameModel) 
	{
		this.spriteList = gameModel.getSpriteList();
		this.background = gameModel.getBackgroundImage();
		this.gameSavable = new GameSavable(gameModel);
	}

	public boolean serialize() {
		try {

			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.setApproveButtonText("Save");
			jfc.setApproveButtonMnemonic('s');
			jfc.setApproveButtonToolTipText("Save Game");
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				FileOutputStream fileOut = new FileOutputStream(selectedFile.getPath());
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(gameSavable);
				out.close();
				fileOut.close();
				return true;
			}
			else {
				return false;
			}
		}catch(Exception i) {
			i.printStackTrace();
		}
		return false;
	}
}

