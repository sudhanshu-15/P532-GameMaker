package game.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class GameVariable implements Serializable{
	private ArrayList<BallVariable> ballDataArray;
	private ArrayList<PaddleVariable> paddleDataArray;
	private ArrayList<BrickVariable> brickDataArray;

	public GameVariable(ArrayList<BallVariable> ballData,ArrayList<PaddleVariable> paddleData,ArrayList<BrickVariable> brickData) {
		this.ballDataArray = ballData;
		this.paddleDataArray = paddleData;
		this.brickDataArray = brickData;
		
	}

	public ArrayList<BallVariable> getBallDataArray() {
		return ballDataArray;
	}

	public void setBallDataArray(ArrayList<BallVariable> ballDataArray) {
		this.ballDataArray = ballDataArray;
	}

	public ArrayList<PaddleVariable> getPaddleDataArray() {
		return paddleDataArray;
	}

	public void setPaddleDataArray(ArrayList<PaddleVariable> paddleDataArray) {
		this.paddleDataArray = paddleDataArray;
	}

	public ArrayList<BrickVariable> getBrickDataArray() {
		return brickDataArray;
	}

	public void setBrickDataArray(ArrayList<BrickVariable> brickDataArray) {
		this.brickDataArray = brickDataArray;
	}

	public boolean save() {
		try {

			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.setApproveButtonText("Save");
			jfc.setApproveButtonMnemonic('s');
			jfc.setApproveButtonToolTipText("Save Game");
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				FileOutputStream fileOut = new FileOutputStream(selectedFile.getPath()+".ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(this.ballDataArray);
				out.writeObject(this.paddleDataArray);
				out.writeObject(this.brickDataArray);
				out.close();
				fileOut.close();
				return true;
			}
		}
		catch(Exception i) 
		{
			i.printStackTrace();
			return false;
		}
		return false;
	}

}
