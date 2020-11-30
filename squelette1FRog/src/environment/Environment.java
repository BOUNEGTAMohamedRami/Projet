package environment;

import java.util.ArrayList;
import java.util.Iterator;


import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;


public class Environment implements IEnvironment {
    private ArrayList<Lane> roadLines;
    private Game game ;

    public Environment(Game game) {
        this.game = game;
        this.roadLines = new ArrayList<>();
        this.roadLines.add(new Lane(game, 0));
        for (int i =1 ; i < game.height; i++) {

            this.roadLines.add(new Lane(game, i));
        }
        this.roadLines.add(new Lane( game , game.height - 1));
    }
    @Override
    public boolean isSafe(Case c) {

     return false;
    }
        @Override
        public boolean isWinningPosition (Case c){
        return c == new Case(c.absc,game.height-1);

        }

        @Override
        public void update () {

        }


        }
