package game.create;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PaddlePanel extends JPanel implements ActionListener,Serializable{
	
	JLabel viewPaddle, actionPaddle, featurePaddle;
	
	JFileChooser chooser = new JFileChooser();
	JRadioButton moveRadioButton, nomoveRadioButton; 
	JCheckBox paddleUpCB, paddleDownCB, paddleLeftCB, paddleRightCB;
	
	GridBagConstraints paddleBag = new GridBagConstraints();
	JButton paddleImage = new JButton("Choose File");
	public PaddlePanel(){
		
		this.setSize(700,200);
		this.setLayout(new GridBagLayout());
		viewPaddle = new JLabel("View");
		actionPaddle = new JLabel("Choose action");
		featurePaddle = new JLabel("Choose Features");
		
		paddleUpCB = new JCheckBox("Up");
		paddleDownCB = new JCheckBox("Down");
		paddleLeftCB = new JCheckBox("Left");
		paddleRightCB = new JCheckBox("Right");
		paddleUpCB.addActionListener(this);
		paddleDownCB.addActionListener(this);
		paddleLeftCB.addActionListener(this);
		paddleRightCB.addActionListener(this);
		
		
		ButtonGroup bg = new ButtonGroup();
		moveRadioButton = new JRadioButton("Move");
		nomoveRadioButton = new JRadioButton("Don't Move");
		moveRadioButton.addActionListener(this);
		nomoveRadioButton.addActionListener(this);
		paddleBag.insets = new Insets(10,10,10,10);
		paddleBag.gridx = 0;
		paddleBag.gridy = 0;
		this.add(viewPaddle, paddleBag);
		paddleBag.gridx = 1;
		paddleBag.gridy = 0;
		paddleImage.addActionListener(this);
		this.add(paddleImage, paddleBag);
		paddleBag.gridx = 0;
		paddleBag.gridy = 1;
		this.add(actionPaddle, paddleBag);
		bg.add(moveRadioButton);
		bg.add(nomoveRadioButton);
		paddleBag.gridx = 1;
		paddleBag.gridy = 1;
		this.add(moveRadioButton, paddleBag);
		paddleBag.gridx = 2;
		paddleBag.gridy = 1;
		this.add(nomoveRadioButton, paddleBag);
		paddleBag.gridx = 0;
		paddleBag.gridy = 2;
		this.add(featurePaddle, paddleBag);
		paddleBag.gridx = 1;
		paddleBag.gridy = 2;
		this.add(paddleUpCB, paddleBag);
		paddleBag.gridx = 2;
		paddleBag.gridy = 2;
		this.add(paddleDownCB, paddleBag);
		paddleBag.gridx = 3;
		paddleBag.gridy = 2;
		this.add(paddleLeftCB, paddleBag);
		paddleBag.gridx = 4;
		paddleBag.gridy = 2;
		this.add(paddleRightCB, paddleBag);
		
		this.setVisible(true);
		repaint();
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == paddleImage){
			
			chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int choice = chooser.showOpenDialog(this);

			if (choice == JFileChooser.APPROVE_OPTION) {

			File chosenFile = chooser.getSelectedFile();
			}
			
		}
		
	}

}
