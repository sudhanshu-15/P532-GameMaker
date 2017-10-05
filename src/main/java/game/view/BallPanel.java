package game.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class BallPanel extends JPanel implements ActionListener,Serializable {

	public static final Logger logBallPanel = Logger.getLogger(BallPanel.class);
	JLabel selectBallImageLabel, ballActionLabel, ballFeatureLabel;
	JButton ballImageSelectionButton;
	JRadioButton moveRadioButton, noMoveRadioButton;
	GridBagConstraints gridBagConstraints = new GridBagConstraints();
	JCheckBox ballHorizontalCB, ballVerticalCB;
	ButtonGroup buttonGroup;

	public BallPanel() {
		this.setSize(700, 200);
		this.setLayout(new GridBagLayout());

		selectBallImageLabel = new JLabel("Select Image");
		ballActionLabel = new JLabel("Choose Actions");
		ballFeatureLabel = new JLabel("Select the Features");

		ballImageSelectionButton = new JButton("Choose File");

		ballHorizontalCB = new JCheckBox("Horizontal");
		ballVerticalCB = new JCheckBox("Vertical");

		ballImageSelectionButton.addActionListener(this);
		ballImageSelectionButton.setActionCommand("ImageForBall");

		buttonGroup = new ButtonGroup();

		moveRadioButton = new JRadioButton("Move");
		moveRadioButton.addActionListener(this);
		moveRadioButton.setActionCommand("Move");

		noMoveRadioButton = new JRadioButton("Don't Move");
		noMoveRadioButton.addActionListener(this);
		noMoveRadioButton.setActionCommand("NoMove");

		buttonGroup.add(moveRadioButton);
		buttonGroup.add(noMoveRadioButton);

		gridBagConstraints.insets = new Insets(10, 10, 10, 10);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;

		this.add(selectBallImageLabel, gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;

		this.add(ballImageSelectionButton, gridBagConstraints);
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;

		this.add(ballActionLabel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		this.add(moveRadioButton, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		this.add(noMoveRadioButton, gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		this.add(ballFeatureLabel, gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		this.add(ballHorizontalCB, gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		this.add(ballVerticalCB, gridBagConstraints);
		this.setVisible(true);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getSource().toString();
		if (source.equals("ImageForBall")) {
			try {
				JFileChooser jfc = new JFileChooser();
				jfc.setApproveButtonText("Open");
				jfc.setApproveButtonMnemonic('o');
				jfc.setApproveButtonToolTipText("Open Game");
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File file = jfc.getSelectedFile();
					FileInputStream fileIn = new FileInputStream(file);
				}
			} catch (IOException i) {
				logBallPanel.error(i);
				//i.printStackTrace();
			}
		} else if (source.equals("Move")) {
			logBallPanel.info("Move clicked");
			
			ballHorizontalCB.setEnabled(true);
			ballVerticalCB.setEnabled(true);
		} else if (source.equals("NoMove")) {
			logBallPanel.info("Nomove cliked");
			
			ballHorizontalCB.setEnabled(false);
			ballVerticalCB.setEnabled(false);
		}

	}

}
