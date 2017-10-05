package game.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PaddleImages extends JPanel implements Serializable {

	Image paddle1_image, paddle2_image;
	JLabel paddle1_label, paddle2_label;
	JRadioButton paddle1RadioButton, paddle2RadioButton;
	ButtonGroup buttonGroup;
	GridBagConstraints gridBag;


	public PaddleImages() {
		
		this.setSize(700, 200);
		gridBag = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		paddle1RadioButton = new JRadioButton("Paddle 1");
		paddle2RadioButton = new JRadioButton("Paddle 2");
		buttonGroup = new ButtonGroup();
		buttonGroup.add(paddle1RadioButton);
		buttonGroup.add(paddle2RadioButton);

		
		this.paddle1_image = new ImageIcon(this.getClass().getClassLoader().getResource("paddle1.jpg")).getImage();
		paddle1_label = imageToLabel(paddle1_image);
		paddle1_label.setBounds(20, 20, 30, 30);
		
		this.paddle2_image = new ImageIcon(this.getClass().getClassLoader().getResource("paddle2.png")).getImage();
		paddle2_label = imageToLabel(paddle2_image);
		paddle2_label.setBounds(20, 20, 30, 30);

		this.add(paddle1_label);
		this.add(paddle2_label);

		gridBag.insets = new Insets(10, 10, 10, 10);
		gridBag.gridx = 0;
		gridBag.gridy = 0;

		this.add(paddle1_label, gridBag);
		gridBag.gridx = 0;
		gridBag.gridy = 1;

		this.add(paddle1RadioButton, gridBag);
		gridBag.gridx = 1;
		gridBag.gridy = 0;

		this.add(paddle2_label, gridBag);
		gridBag.gridx = 1;
		gridBag.gridy = 1;
		this.add(paddle2RadioButton, gridBag);

		setFocusable(false);
		this.setVisible(true);
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 100);
	}

	public JLabel imageToLabel(Image paddle1) {

		paddle1 = paddle1.getScaledInstance(150, 30, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(paddle1);
		JLabel imglabel = new JLabel();
		if (icon != null) {

			imglabel.setIcon(icon);

		}

		return imglabel;

	}
}
