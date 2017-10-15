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
import com.game.hibernate.SignUpHandler;
import com.game.view.GameFrame;


public class Main {
	
	private static boolean userRegistered = false;
	private static int playerId = -1;

	public static void main(String[] args) {
		final JPanel userLoginPanel = new JPanel();
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
				
				playerId = loginHandler.isUserRegistered();
				
				System.out.println("playerId"+playerId);
				if(playerId != -1){
					userRegistered = true;
					System.out.println("userRegistered" + userRegistered);
					loginDialog.dispose();
					startGame();
				}
				else{
					JOptionPane.showMessageDialog(userLoginPanel, "Signup to Login and Have fun");
				}
			}
		});
		
		signUpButton.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent e)	{
				String input = userInput.getText();
				SignUpHandler signUpHandler = new SignUpHandler(input);
				if(signUpHandler.isUserNameExistsAlready()){
					  JOptionPane.showMessageDialog(userLoginPanel, "User Name Already Exists! - Try another Name");
				}
				else{
					signUpHandler.registerPlayer();
					loginDialog.dispose();
					userRegistered = true;
					startGame();
				}
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
		
		

}
