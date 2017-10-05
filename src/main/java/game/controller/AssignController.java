package game.controller;

import java.util.LinkedList;
import java.util.List;

import game.model.AutoSprite;
import game.model.CommandSprite;
import game.view.GameView;

public class AssignController {
	GameView gameView;

	public AssignController(GameView gameView) {
		this.gameView = gameView;
	}

	public List<AutoCtrl> assignAutoCtrl(List<AutoSprite> autoSpriteList) {
		List<AutoCtrl> autoCtrlList = new LinkedList<>();
		for (AutoSprite currSprite : autoSpriteList) {
			AutoCtrl autoCtrl = new AutoCtrl(gameView, currSprite);
			autoCtrlList.add(autoCtrl);
		}
		return autoCtrlList;
	}

	public List<CommandCtrl> assignCommandCtrl(List<CommandSprite> commandSpriteList) {
		List<CommandCtrl> commandCtrlList = new LinkedList<>();
		for (CommandSprite currSprite : commandSpriteList) {
			CommandCtrl commandCtrl = new CommandCtrl(gameView, currSprite);
			commandCtrlList.add(commandCtrl);
		}
		return commandCtrlList;
	}
}
