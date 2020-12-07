package frog;

import gameCommons.Game;
import gameCommons.GameInf;

import gameCommons.IFrog;
import graphicalElements.Element;
import util.Case;
import util.Direction;

import java.awt.*;

public class    FrogInf implements IFrog {

    private GameInf game;
    private Case myPosition;
    private Direction newDirection;


    public FrogInf(GameInf game){
        this.game = game;
        this.myPosition = new Case(game.width/2 ,1);
        this.newDirection = null;
    }

    @Override
    public Case getPosition() {
        return this.myPosition;
    }

    @Override
    public Direction getDirection() {
        return this.newDirection;
    }

    @Override
    public void move(Direction key) {
        this.newDirection = key;
        if (key == Direction.up) {
            this.myPosition = new Case(this.myPosition.absc, this.myPosition.ord + 1);
            ++this.game.movement_up_down;
            this.game.addLane();
        }

        if (key == Direction.down && this.myPosition.ord > 1) {
            this.myPosition = new Case(this.myPosition.absc, this.myPosition.ord - 1);
            --this.game.movement_up_down;
        }

        if (key == Direction.right && this.myPosition.absc < this.game.width - 1) {
            this.myPosition = new Case(this.myPosition.absc + 1, this.myPosition.ord);
        }

        if (key == Direction.left && this.myPosition.absc > 0) {
            this.myPosition = new Case(this.myPosition.absc - 1, this.myPosition.ord);
        }

        this.game.getGraphic().add(new Element(this.myPosition.absc, 1, Color.GREEN));
        this.game.testWin();
        this.game.testLose();

    }}

