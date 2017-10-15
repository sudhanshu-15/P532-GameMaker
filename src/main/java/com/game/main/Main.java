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

import com.game.view.GameFrame;


public class Main {

	public static void main(String[] args) {
		JPanel userLoginPanel = new JPanel();
		JDialog loginDialog = new JDialog();
		final JTextField userInput = new JTextField();
		JLabel userNameLabel = new JLabel("Enter your name: ");
		userInput.setPreferredSize(new Dimension(300,30));
		JButton loginButton = new JButton("Log in");
		JButton signUpButton = new JButton("Sign up");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {					
				
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
		
		new GameFrame();
	}
	
	

	

}
