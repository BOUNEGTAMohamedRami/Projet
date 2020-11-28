package environment;

import java.util.ArrayList;


import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

public class Environment implements IEnvironment {
    public Environment(Game game) {

    }

    @Override
    public boolean isSafe(Case c) {
        return false;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return false;
    }

    @Override
    public void update() {

    }

    //TODO

}
