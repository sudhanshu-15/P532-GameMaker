package game.save;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class GameSave{

	private ArrayList spriteList;
	private Image background;
	private GameSavable gameSavable;

	public GameSave(ArrayList list) 
	{
		this.spriteList = list;
		this.background = background;
		
		gameSavable = new GameSavable(this.spriteList, this.background);
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
				FileOutputStream fileOut = new FileOutputStream(selectedFile.getPath()+".txt");
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

