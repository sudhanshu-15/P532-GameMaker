package game.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BrickPanel extends JPanel implements Serializable {

	JLabel viewBrick, actionBrick;
	JButton brickImage;
	JRadioButton blowRadioButton, noblowRadioButton;
	GridBagConstraints brickBag = new GridBagConstraints();
	JFileChooser chooser = new JFileChooser();

	public BrickPanel() {

		this.setSize(700, 200);
		this.setLayout(new GridBagLayout());
		viewBrick = new JLabel("Select Image");
		actionBrick = new JLabel("Choose action");
		brickImage = new JButton("Choose File");
		// brickImage.addActionListener(this);

		ButtonGroup bg = new ButtonGroup();
		blowRadioButton = new JRadioButton("Blow");
		noblowRadioButton = new JRadioButton("Don't blow up");

		// blowRadioButton.addActionListener(this);
		// noblowRadioButton.addActionListener(this);

		brickBag.insets = new Insets(10, 10, 10, 10);
		brickBag.gridx = 0;
		brickBag.gridy = 0;
		this.add(viewBrick, brickBag);
		brickBag.gridx = 1;
		brickBag.gridy = 0;
		this.add(brickImage, brickBag);
		brickBag.gridx = 0;
		brickBag.gridy = 1;
		this.add(actionBrick, brickBag);
		bg.add(blowRadioButton);
		bg.add(noblowRadioButton);
		brickBag.gridx = 1;
		brickBag.gridy = 1;
		this.add(blowRadioButton, brickBag);
		brickBag.gridx = 2;
		brickBag.gridy = 1;
		this.add(noblowRadioButton, brickBag);
		this.setVisible(true);
		repaint();
	}
}
