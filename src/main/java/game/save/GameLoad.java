package game.save;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class GameLoad {

	private ArrayList<BallVariable> ballDataArray;
	private ArrayList<PaddleVariable> paddleDataArray;
	private ArrayList<BrickVariable> brickDataArray;

	@SuppressWarnings("unchecked")
	public boolean loadGame() throws IOException, ClassNotFoundException {
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

				this.ballDataArray = (ArrayList<BallVariable>) in.readObject();
				this.paddleDataArray = (ArrayList<PaddleVariable>) in.readObject();
				this.brickDataArray = (ArrayList<BrickVariable>) in.readObject();
				
				for(int i = 0;i<this.ballDataArray.size();i++) 
				{
					this.ballDataArray.get(i).setBallImage();
				}
				
				for(int i = 0;i<this.paddleDataArray.size();i++) 
				{
					this.paddleDataArray.get(i).setPaddleImage();
				}
				
				for(int i = 0;i<this.brickDataArray.size();i++) 
				{
					this.brickDataArray.get(i).setBrickImage();
				}
				in.close();
				fileIn.close();
				return true;
			}
		} catch (IOException i) {
			i.printStackTrace();
			return false;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return false;
		}
		return false;

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

}
