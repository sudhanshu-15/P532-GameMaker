package game.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlayPanel extends JPanel implements Serializable{

	int spriteX, spriteY;
	Image imgBall1, imgBall2, imgPaddle1, imgPaddle2, imgBrick1, imgBrick2;

	PlayPanel playPane;

	public PlayPanel() {

		setFocusable(false);
		imgBrick1 = new ImageIcon(this.getClass().getClassLoader().getResource("brick1.jpg")).getImage();
		imgBrick1 = imgBrick1.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		setVisible(true);
	}

	public void setBackground(int backgroundColorIndex) {
		//System.out.println(backgroundColorIndex);
		switch (backgroundColorIndex) 
		{
		case 1:
			this.setBackground(Color.BLACK);
			this.repaint();
			break;
		case 2:
			this.setBackground(Color.GREEN);
			this.repaint();
			break;
		case 3:
			this.setBackground(Color.BLUE);
			this.repaint();
			break;

		}
	}

	public void draw(Graphics g, int i) {

		if (i == 1) {

			g.drawImage(imgBrick1, 30, 30, 60, 60, this);
			this.revalidate();
		}
		// g.setColor(Color.BLACK);
		// g.fillRect(spriteX,spriteY, 30, 30);
	}
}