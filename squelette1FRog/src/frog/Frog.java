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
	this.myPosition = new Case(12 ,0);
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
	    if (key ==Direction.up){
        myPosition.ord= myPosition.ord + 1;
	    };
	    if (key == Direction.left){
	        myPosition.absc= myPosition.absc -1 ;
        };
	    if (key == Direction.down){
	        myPosition.ord = myPosition.ord - 1;
        }
	    if (key == Direction.right){
	        myPosition.absc = myPosition.absc + 1;
        }



	}
}
