package game.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class BrickImages extends JPanel implements Serializable{

	Image brick1_image, brick2_image;
	JLabel brick1_label, brick2_label;
	int brickFlag;

	JRadioButton brick1RadioButton, brick2RadioButton;
	ButtonGroup bg;
	GridBagConstraints gridBag = new GridBagConstraints();

	PlayPanel playPane = new PlayPanel();

	public BrickImages() {

		this.setSize(700, 200);
		this.setLayout(new GridBagLayout());

		brick1RadioButton = new JRadioButton("Brick 1");
		brick2RadioButton = new JRadioButton("Brick 2");
		bg = new ButtonGroup();
		bg.add(brick1RadioButton);
		bg.add(brick2RadioButton);

		this.brick1_image = new ImageIcon(this.getClass().getClassLoader().getResource("brick1.jpg")).getImage();
		brick1_label = imageToLabel(brick1_image);
		brick1_label.setBounds(20, 20, 30, 30);

		this.brick2_image = new ImageIcon(this.getClass().getClassLoader().getResource("brick2.png")).getImage();
		brick2_label = imageToLabel(brick2_image);
		brick2_label.setBounds(20, 20, 30, 30);

		setFocusable(false);
		gridBag.insets = new Insets(10, 10, 10, 10);
		gridBag.gridx = 0;
		gridBag.gridy = 0;

		this.add(brick1_label, gridBag);
		gridBag.gridx = 0;
		gridBag.gridy = 1;

		this.add(brick1RadioButton, gridBag);
		gridBag.gridx = 1;
		gridBag.gridy = 0;

		this.add(brick2_label, gridBag);
		gridBag.gridx = 1;
		gridBag.gridy = 1;
		this.add(brick2RadioButton, gridBag);

		this.setVisible(true);
	}

	public Dimension getPreferredSize() {
		return new Dimension(400, 100);
	}

	public JLabel imageToLabel(Image brick1) {

		brick1 = brick1.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(brick1);
		JLabel imglabel = new JLabel();
		if (icon != null) {

			imglabel.setIcon(icon);

		}

		return imglabel;

	}
}
