package com.game.save;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
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
				
				saveGameToDatabase();
				
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
	
	public boolean saveGameToDatabase(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();  
        session.beginTransaction();  
        
        System.out.println("saveGameToDatabase called");
        Game game = new Game(); 
        //UserTest newUser = new UserTest();
       
        //setting a temp user name --- going forward give flexibility for the user to give a name
        // setting the gameSavable to this gameSavable when user clicks save
        //gameSavable = new GameSavable(new GameModel());
        game.setGameName("temp");
        game.setGameSavable(gameSavable);
        
        System.out.println("success : stored game in database");
        
        System.out.println(gameSavable);
        
        
        //newUser.setName("Shuwen");
        //newUser.setScore(100);
        
        session.save(game);
        session.getTransaction().commit();
        
        session.close();
		
		return false;
		
	}
}

