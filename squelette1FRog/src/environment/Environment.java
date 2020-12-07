package environment;

import java.util.ArrayList;




import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;


public class Environment implements IEnvironment {
    private ArrayList<Lane> roadLines;
    private Game game;

    public Environment(Game game) {
        this.game = game;
        this.roadLines = new ArrayList<>();
        for (int i = 1; i < game.height - 1; i++) {

            this.roadLines.add(new Lane(game, i));
        }

    }

    @Override
    public boolean isSafe(Case c) {
        if (c.ord < 1 || c.ord >= game.height - 1) {
            return true;
        } else {
            return roadLines.get(c.ord - 1).isSafe(c);
        }
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == game.height - 1;

    }

    @Override
    public void update() {
        for (Lane lane : roadLines) {
            lane.update();
        }
    }
    public void addLane(){}

}
