package com.game.save;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class GameLoad {
	
	public GameSavable deserialize() {
		try {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setApproveButtonText("Open");
			jfc.setApproveButtonMnemonic('o');
			jfc.setApproveButtonToolTipText("Open Game");
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				FileInputStream fileIn = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fileIn);

				GameSavable gameSavable = (GameSavable) in.readObject();
				if(gameSavable != null) {
					return gameSavable;
				}
				in.close();
				fileIn.close();
			}
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return null;
		}
		return null;

	}
}
