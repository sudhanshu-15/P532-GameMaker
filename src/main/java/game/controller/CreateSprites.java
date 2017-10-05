package game.controller;

import java.util.ArrayList;
import java.util.List;

import game.helper.BallVariable;
import game.helper.BrickVariable;
import game.helper.Constants;
import game.helper.GameVariable;
import game.helper.PaddleVariable;
import game.model.AutoSprite;
import game.model.CommandSprite;

/**
 * @author shubham 
 */

public class CreateSprites {

	GameVariable gameVariable;
	List<AutoSprite> autoSpriteList;
	List<CommandSprite> cmdSpriteList;
	
	public CreateSprites() {
		// TODO Auto-generated constructor stub
	}
	public void create(GameVariable gameVariable) {
		this.gameVariable = gameVariable;
	    autoSpriteList = new ArrayList<AutoSprite>();
	    cmdSpriteList = new ArrayList<CommandSprite>();
	}
	public List<AutoSprite> createAutoSprite()
	{
		AutoSprite autoSprite=null;
		//will create a auto sprite for brick
		for(BrickVariable var:gameVariable.getBrickDataArray())
		{
			autoSprite = new AutoSprite(var.getLocation_X(), var.getLocation_Y(), var.getBrickImage(),Constants.BRICK_HEIGHT ,Constants.BRICK_WIDTH, false, false, true, false);
			autoSpriteList.add(autoSprite);
		}
		
		//will create a auto sprite for ball
		for(BallVariable var:gameVariable.getBallDataArray())
		{
			autoSprite = new AutoSprite(var.getLocation_X(), var.getLocation_Y(), var.getBallImage(),Constants.BALL_HEIGHT ,Constants.BALL_WIDTH, var.isMoveHorizontal(), var.isMoveVertical(), false, false);
			autoSpriteList.add(autoSprite);
		}
		
		return autoSpriteList;
	}
	
	public List<CommandSprite> createCommandSprite()
	{
		CommandSprite cmdSprite = null;
		//will create a command sprite for paddle
		for(PaddleVariable var:gameVariable.getPaddleDataArray())
		{
			 cmdSprite = new CommandSprite(var.getLocation_X(), var.getLocation_Y(),var.getPaddleImage(),Constants.PADDLE_HEIGHT, Constants.PADDLE_WIDTH, var.isMoveLeft(),var.isMoveRight(), var.isMoveUp(), var.isMoveDown());
		}
		cmdSpriteList.add(cmdSprite);
		return cmdSpriteList;
	}
	
}
