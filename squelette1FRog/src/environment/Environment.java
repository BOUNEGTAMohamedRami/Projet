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


    }
    @Override
    public boolean isSafe(Case c) {
     return false;
    }
        @Override
        public boolean isWinningPosition (Case c){
    return false;
        }

        @Override
        public void update () {

        }


        }
