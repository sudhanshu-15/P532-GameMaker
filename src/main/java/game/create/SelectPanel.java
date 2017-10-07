package game.create;

import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.game.main.StartGame;
import com.game.view.GameView;

import game.play.PlayPanel;
import game.save.*;

public class SelectPanel extends JPanel implements ActionListener,Serializable {

	public static final Logger logSelectPanel = Logger.getLogger(SelectPanel.class);
	private String[] sprites = { "Select a sprite","Ball", "Paddle", "Brick" };
	private String[] backgrounds = { "Select a color","Black", "Green", "Blue" };
	JPanel choicePanel = new JPanel();
	JButton saveButton, loadButton, addButton, clockButton,playButton;
	Map<String, Integer> buttonActionMap;
	JComboBox spriteListComboBox, backGroundsComboBox;

	public BallPanel ballPanel;
	BallImages ballImagePanel;

	BrickPanel brickPanel;
	BrickImages brickImagePanel;

	PaddlePanel paddlePanel;
	PaddleImages paddleImagePanel;

	GridBagConstraints gridBagConstraints;

	GameView playPane;
	int spriteX, spriteY;

	private ArrayList<BallVariable> ballDataArray;
	private ArrayList<PaddleVariable> paddleDataArray;
	private ArrayList<BrickVariable> brickDataArray;
	private StartGame startGame;
	int flagSprite, flagBall;

	public StartGame getStartGame() {
		return startGame;
	}

	public void setStartGame(StartGame startGame) {
		this.startGame = startGame;
	}

	public SelectPanel(GameView playPane) {

		this.playPane = playPane;
		setLayout(new GridBagLayout());
		choicePanel.setSize(700, 150);
		setFocusable(false);

		ballPanel = new BallPanel();
		ballImagePanel = new BallImages();

		brickPanel = new BrickPanel();
		brickImagePanel = new BrickImages();

		paddlePanel = new PaddlePanel();
		paddleImagePanel = new PaddleImages();

		gridBagConstraints = new GridBagConstraints();

		ballDataArray = new ArrayList<BallVariable>();
		paddleDataArray = new ArrayList<PaddleVariable>();
		brickDataArray = new ArrayList<BrickVariable>();

		spriteListComboBox = new JComboBox();

		for (int i = 0; i < 4; i++) 
		{
			spriteListComboBox.addItem(sprites[i]);
		}

		backGroundsComboBox = new JComboBox();

		for (int i = 0; i < 4; i++) 
		{
			backGroundsComboBox.addItem(backgrounds[i]);
		}

		spriteListComboBox.addActionListener(this);
		backGroundsComboBox.addActionListener(this);

		gridBagConstraints.insets = new Insets(10, 10, 10, 10);


		buttonActionMap = new HashMap<String, Integer>();
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		saveButton.setActionCommand("SAVE");
		buttonActionMap.put("SAVE", new Integer(0));

		loadButton = new JButton("Load");
		loadButton.addActionListener(this);
		loadButton.setActionCommand("LOAD");
		buttonActionMap.put("LOAD", new Integer(1));

		addButton = new JButton("Add");
		addButton.addActionListener(this);
		addButton.setActionCommand("ADD");
		buttonActionMap.put("ADD", new Integer(2));

		clockButton = new JButton("Clock");
		clockButton.addActionListener(this);
		clockButton.setActionCommand("CLOCK");
		buttonActionMap.put("CLOCK", new Integer(3));

		playButton= new JButton("Play");
		playButton.addActionListener(this);
		playButton.setActionCommand("PLAY");
		buttonActionMap.put("PLAY", new Integer(4));

		choicePanel.setLayout(new FlowLayout());
		choicePanel.add(spriteListComboBox);
		choicePanel.add(backGroundsComboBox);
		choicePanel.add(saveButton);
		choicePanel.add(loadButton);
		choicePanel.add(addButton);
		choicePanel.add(clockButton);
		choicePanel.add(playButton);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;

		ballImagePanel.setVisible(false);
		paddleImagePanel.setVisible(false);
		brickImagePanel.setVisible(false);

		this.add(ballImagePanel, gridBagConstraints);
		this.add(paddleImagePanel, gridBagConstraints);
		this.add(brickImagePanel, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 10;

		this.add(choicePanel, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 20;
		ballPanel.setVisible(false);
		paddlePanel.setVisible(false);
		brickPanel.setVisible(false);

		this.add(ballPanel, gridBagConstraints);
		this.add(brickPanel, gridBagConstraints);
		this.add(paddlePanel, gridBagConstraints);
		this.setVisible(true);
		repaint();
	}

	public void actionPerformed(ActionEvent e) {

		int sprite_index = spriteListComboBox.getSelectedIndex();

		switch (sprite_index) {
		case 0: hideAllPanels();
		this.revalidate();
		case 1:
			// Ball
			hideAllPanels();
			ballPanel.setVisible(true);
			ballImagePanel.setVisible(true);
			this.revalidate();
			break;
		case 2:
			// Paddle
			hideAllPanels();
			paddlePanel.setVisible(true);
			paddleImagePanel.setVisible(true);
			this.revalidate();
			break;
		case 3:
			// Brick
			hideAllPanels();
			brickPanel.setVisible(true);
			brickImagePanel.setVisible(true);
			this.revalidate();
			break;
		}

		int backgroundColorIndex = backGroundsComboBox.getSelectedIndex();



		try {

			String btnText = e.getActionCommand().toString();
			logSelectPanel.info(btnText);

			int index = buttonActionMap.get(btnText).intValue();
			logSelectPanel.info("index: " + String.valueOf(index) );


			switch(index) {
			case 0:
				// Save
				logSelectPanel.info("save clicked");

				GameVariable gameVariable = new GameVariable(this.ballDataArray,this.paddleDataArray,this.brickDataArray);

				//gameVariable.setBallDataArray(this.ballDataArray);
				//gameVariable.setPaddleDataArray(this.paddleDataArray);
				//gameVariable.setBrickDataArray(this.brickDataArray);

				if(gameVariable.save()) 
				{
					JOptionPane.showMessageDialog(null,
							"Save Successful",
							"Save",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else 
				{
					JOptionPane.showMessageDialog(null,
							"Error Saving Game",
							"Save",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 1:
				// Load
				logSelectPanel.info("Load clicked");
				GameLoad gl = new GameLoad();
				if(gl.loadGame()) {
					JOptionPane.showMessageDialog(null,
							"Load Successful",
							"Load",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,
							"Error Loading Game",
							"Load",
							JOptionPane.ERROR_MESSAGE);

				}
				GameVariable loadedGame = new GameVariable(gl.getBallDataArray(),gl.getPaddleDataArray(),gl.getBrickDataArray());
				logSelectPanel.info(loadedGame+"game variable");
				startGame.setGameVariable(loadedGame);
				startGame.start();

				//System.out.println("Load clicked");
				break;
			case 2:
				// Add
				logSelectPanel.info("Add clicked");
				//System.out.println("Add Clicked");
				addSprite();
				break;
			case 3:
				// Clock
				logSelectPanel.info("clock clicked");
				Timer timer = new Timer();
				timer.schedule(new GameClock(), 0, 1000);
				//System.out.println("Clock clicked");
				break;
			case 4:
				// Play
				logSelectPanel.info("play clicked");
				//System.out.println("Play clicked");
				GameVariable gv = new GameVariable(this.ballDataArray,this.paddleDataArray,this.brickDataArray);
				logSelectPanel.info(gv+"game variable");
				//System.out.println(gv+"game variable");
				startGame.setGameVariable(gv);
				startGame.start();

				break;
			}
		}catch(Exception e1) {
			logSelectPanel.error(e1);
			//System.out.println(e1.getMessage());
		}
	}

	public int addSprite() 
	{
		flagSprite = 1;
		int sel_ind = spriteListComboBox.getSelectedIndex();

		switch (sel_ind) {
		case 1:
			// Ball
			addBallToList();
			break;
		case 2:
			// Paddle
			addPaddleToList();
			break;
		case 3:
			// Brick
			addBrickToList();
			break;
		}
		return flagSprite;
	}

	private void addBrickToList() {
		try {
			BrickVariable brick = new BrickVariable();
			brick.setLocation_X(10);
			brick.setLocation_Y(20);

			if (brickImagePanel != null) 
			{
				if (brickImagePanel.brick1RadioButton.isSelected()) 
				{
					brick.setBrickImageIndex(1);
				} 
				else 
				{
					brick.setBrickImageIndex(2);
				}
			}

			if (brickPanel != null) 
			{
				if (brickPanel.blowRadioButton.isSelected()) 
				{
					brick.setDisappear(true);
				} 
				else 
				{
					brick.setDisappear(false);
				}
			}

			logSelectPanel.info(brick.toString());
			//System.out.println(brick.toString());
			brickDataArray.add(brick);
		} catch (Exception e) {
			logSelectPanel.info(e.toString());
			//System.out.println(e.toString());
		}		
	}

	private void addPaddleToList() {
		try {
			PaddleVariable paddle = new PaddleVariable();
			paddle.setLocation_X(300);
			paddle.setLocation_Y(500);

			if (paddleImagePanel != null) 
			{
				if (paddleImagePanel.paddle1RadioButton.isSelected()) {
					paddle.setPaddleImageIndex(1);
				} else {
					paddle.setPaddleImageIndex(2);
				}
			}

			if (paddlePanel != null) 
			{
				if (paddlePanel.moveRadioButton.isSelected()) 
				{
					paddle.setIfMove(true);
					if(paddlePanel.paddleLeftCB.isSelected()) 
					{
						paddle.setMoveLeft(true);
					}
					if(paddlePanel.paddleRightCB.isSelected()) 
					{
						paddle.setMoveRight(true);
					}
					if(paddlePanel.paddleUpCB.isSelected()) 
					{
						paddle.setMoveUp(true);
					}
					if(paddlePanel.paddleDownCB.isSelected()) 
					{
						paddle.setMoveDown(true);
					}
				} 
				else 
				{
					paddle.setIfMove(false);
					paddle.setMoveLeft(false);
					paddle.setMoveRight(false);
					paddle.setMoveUp(false);
					paddle.setMoveDown(false);
				}
			}

			logSelectPanel.info(paddle.toString());
			//System.out.println(paddle.toString());
			paddleDataArray.add(paddle);
		} catch (Exception e) {
			logSelectPanel.info(e.toString());
			//System.out.println(e.toString());
		}
	}

	public int addBallToList() {
		flagBall = 1;
		try {
			BallVariable ball = new BallVariable();
			ball.setLocation_X(120);
			ball.setLocation_Y(200);

			if (ballImagePanel != null) {
				if (ballImagePanel.b1.isSelected()) {
					ball.setBallImageIndex(1);
				} else {
					ball.setBallImageIndex(2);
				}
			}

			if (ballPanel != null) {
				if (ballPanel.noMoveRadioButton.isSelected()) {
					ball.setMoveHorizontal(false);
					ball.setMoveVertical(false);
				} else {
					if (ballPanel.ballHorizontalCB.isSelected()) {
						ball.setMoveHorizontal(true);
					} else {
						ball.setMoveHorizontal(false);
					}

					if (ballPanel.ballVerticalCB.isSelected()) {
						ball.setMoveVertical(true);
					} else {
						ball.setMoveVertical(false);
					}
				}
			}

			//System.out.println(ball.toString());
			ballDataArray.add(ball);
		} catch (Exception e) {
			//System.out.println(e.toString());
		}
		return flagBall;
	}

	public void hideAllPanels() {

		ballPanel.setVisible(false);
		ballImagePanel.setVisible(false);
		paddlePanel.setVisible(false);
		brickPanel.setVisible(false);
		paddleImagePanel.setVisible(false);
		brickImagePanel.setVisible(false);
	}

}
