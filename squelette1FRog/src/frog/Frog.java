package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {

    private Game game;
    private Case myPosition;
    private Direction newDirection;


    public Frog (Game game){
        this.game = game;
        this.myPosition = new Case(12 ,0);
        this.newDirection = null;
    }

    @Override
    public Case getPosition() {
        return this.myPosition;
    }

    @Override
    public Direction getDirection() {
        return null;
        //return this.newDirection;
    }

    @Override
    public void move(Direction key) {


        if (key.equals(Direction.up)){
            if (myPosition.ord >=19) {
            } else {
                 //myDirection = Direction.up ;
                 myPosition = new Case ( myPosition.absc, myPosition.ord + 1);

            }
        };
        if (key.equals(Direction.down)){
            if (myPosition.ord <=0) {
            } else {
               // myDirection = Direction.down;
                myPosition = new Case (myPosition.absc  , myPosition.ord - 1);
            }
        };
        if (key.equals(Direction.right)){
            if (myPosition.absc >=25) {
            } else {
                //myDirection = Direction.right;
                myPosition = new Case( myPosition.absc+1, myPosition.ord);
            }
        };
        if (key.equals(Direction.left)){
            if (myPosition.absc <=0) {
            } else {
                //myDirection = Direction.left;
                myPosition = new Case(myPosition.absc-1, myPosition.ord);
            }
        };



    }
}