package com.game.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.game.hibernate.LoginHandler;
import com.game.view.GameFrame;


public class Main {
	
	private static boolean userRegistered = false;

	public static void main(String[] args) {
		JPanel userLoginPanel = new JPanel();
		final JDialog loginDialog = new JDialog();
		final JTextField userInput = new JTextField();
		JLabel userNameLabel = new JLabel("Enter your name: ");
		userInput.setPreferredSize(new Dimension(300,30));
		JButton loginButton = new JButton("Log in");
		JButton signUpButton = new JButton("Sign up");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {					
				String input = userInput.getText();
				LoginHandler loginHandler = new LoginHandler(input);
				if(loginHandler.isUserRegistered()){
					userRegistered = true;
					System.out.println("userRegistered" + userRegistered);
					loginDialog.dispose();
					startGame();
				}
			}
		});
		
		signUpButton.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent e)	{
				
			}
		});
		
		
		userLoginPanel.add(userNameLabel);
		userLoginPanel.add(userInput);
		userLoginPanel.add(loginButton);
		userLoginPanel.add(signUpButton);

		loginDialog.setSize(new Dimension(300,200));
		loginDialog.add(userLoginPanel);
		loginDialog.setVisible(true);
		
	}
	
	public static void startGame(){
		if(userRegistered){
			
			System.out.println(" in main : works if user registered-- calls new gameFrame");
			new GameFrame();
		}
	}
		
		
	
/*	public boolean isUserRegistered() {
		return userRegistered;
	}

	public void setUserRegistered(boolean userRegistered) {
		this.userRegistered = userRegistered;
	}
*/	
	

	

}
