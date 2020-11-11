package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Case myPosition;

	public Frog (Game game){
	this.game = game;
	this.myPosition = new Case(5 ,0);
	}

	@Override
	public Case getPosition() {
		return this.myPosition;
	}

	@Override
	public Direction getDirection() {
		return null;
	}

	@Override
	public void move(Direction key) {

	}
}
