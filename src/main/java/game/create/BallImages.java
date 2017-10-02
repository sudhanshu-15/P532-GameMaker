package game.create;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class BallImages extends JPanel implements Serializable{

	Image ball1_image, ball2_image;
	JLabel ball1_label, ball2_label;
	JButton btn_add, btn_sub, btn_mul;
	JRadioButton b1, b2;
	ButtonGroup bg;
	GridBagConstraints gridBag = new GridBagConstraints();

	public BallImages() {

		this.setSize(700, 200);
		this.setLayout(new GridBagLayout());

		b1 = new JRadioButton("Ball 1");
		b2 = new JRadioButton("Ball 2");
		bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		b1.setSelected(true);

		
		this.ball1_image = new ImageIcon(this.getClass().getClassLoader().getResource("ball1.png")).getImage();
		ball1_label = imageToLabel(ball1_image);
		ball1_label.setBounds(20, 20, 30, 30);

		this.ball2_image = new ImageIcon(this.getClass().getClassLoader().getResource("ball2.png")).getImage();
		ball2_label = imageToLabel(ball2_image);
		ball2_label.setBounds(20, 20, 30, 30);
		
		gridBag.insets = new Insets(10, 10, 10, 10);
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		this.add(ball1_label, gridBag);
		
		gridBag.gridx = 0;
		gridBag.gridy = 1;
		this.add(b1, gridBag);
		
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		this.add(ball2_label, gridBag);
		
		gridBag.gridx = 1;
		gridBag.gridy = 1;
		this.add(b2, gridBag);
		
		setFocusable(false);
		this.setVisible(true);
	}

	public JLabel imageToLabel(Image ballImage) {

		ballImage = ballImage.getScaledInstance(70, 60, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(ballImage);
		JLabel imgLabel = new JLabel();
		if (icon != null) {
			imgLabel.setIcon(icon);
		}
		return imgLabel;
	}

}
