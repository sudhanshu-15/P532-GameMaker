package com.game.save;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.game.hibernate.HibernateUtil;
import com.game.model.GameModel;
import com.game.model.Sprite;
import com.game.pojos.Game;
import com.game.strategy.Music;

public class GameSave{

	private ArrayList<Sprite> spriteList;
	private Image background;
	public GameSavable gameSavable;
	private GameModel gameModel;
	JDialog saveDialog = new JDialog();
	
	public GameSave(GameModel gameModel) 
	{
		this.spriteList = gameModel.getSpriteList();
		this.background = gameModel.getBackgroundImage();
		this.gameSavable = new GameSavable(gameModel);
	}

	/**
	 * Function called when user click save
	 * @return
	 */
	public boolean serialize() {
		try {

//			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//			jfc.setApproveButtonText("Save");
//			jfc.setApproveButtonMnemonic('s');
//			jfc.setApproveButtonToolTipText("Save Game");
//			int returnValue = jfc.showSaveDialog(null);
//			if (returnValue == JFileChooser.APPROVE_OPTION) {
//				File selectedFile = jfc.getSelectedFile();
//				FileOutputStream fileOut = new FileOutputStream(selectedFile.getPath());
//				ObjectOutputStream out = new ObjectOutputStream(fileOut);
//				out.writeObject(gameSavable);
//				
//				saveGameToDatabase();
//				
//				out.close();
//				fileOut.close();
//				return true;
//			}
//			else {
//				return false;
//			}
			
			// TODO pop up panel to enter game name
			saveGameDialog();
			return true;
			
			
		}catch(Exception i) {
			i.printStackTrace();
		}
		return false;
	}
	
	private void saveGameDialog() {
		JPanel saveGamePanel = new JPanel();
		JLabel gameLabel = new JLabel("Please enter the name of your game: ");
		final JTextField userInput = new JTextField();
		JButton saveGameButton = new JButton("Save");
//		final JLabel errorMsg = new JLabel("Game name is required");
//		errorMsg.setForeground(Color.RED);
		
		userInput.setPreferredSize(new Dimension(300,30));
		saveGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = userInput.getText();
//				if (input.isEmpty()) {
//					errorMsg.setVisible(true);
//				}	else	  {
//					errorMsg.setVisible(false);
					saveGameToDatabase(input);
					saveDialog.dispose();
					JOptionPane.showMessageDialog(null,
							"Save Successful",
							"Save",
							JOptionPane.INFORMATION_MESSAGE);					
//				}
				
			}
		});
		
		saveGamePanel.add(gameLabel);
		saveGamePanel.add(userInput);
		saveGamePanel.add(saveGameButton);
//		saveGamePanel.add(errorMsg);
		saveDialog.setSize(new Dimension(300,200));
		saveDialog.add(saveGamePanel);
		saveDialog.setVisible(true);
	}
	
	public boolean saveGameToDatabase(String inputName){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();  
        session.beginTransaction();  
        
        System.out.println("saveGameToDatabase called");
        Game game = new Game(); 
       
        //setting a temp user name --- going forward give flexibility for the user to give a name
        // setting the gameSavable to this gameSavable when user clicks save
        game.setGameName(inputName);
        game.setGameSavable(gameSavable);
        
        System.out.println("success : stored game in database");
        
        System.out.println(gameSavable);
        
        
        session.save(game);
        session.getTransaction().commit();
        
        // TODO Test if game name save successful
//        ArrayList<Game> games = (ArrayList<Game>) session.createQuery("from Game").list();  
        
        session.close();
		
//        // TODO Test if game name save successful
//        for (Game game1 : games) {  
//            System.out.println(game1.getGameId() + "--" + game1.getGameName() + "--" + game1.getGameSavable());  
//        } 
        
		return false;
		
	}
}

