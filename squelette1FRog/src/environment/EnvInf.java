package environment;

import java.util.ArrayList;
import java.util.Iterator;

import gameCommons.GameInf;
import gameCommons.IEnvironment;
import util.Case;

public class EnvInf implements IEnvironment {
    private ArrayList<LaneInf> roadLines;
    private GameInf game;

    public EnvInf(GameInf game) {
        this.game = game;
        this.roadLines = new ArrayList();
        this.roadLines.add(new LaneInf(game, 0, 0.00D));
        this.roadLines.add(new LaneInf(game, 1, 0.00D));

        for(int i = 2; i < game.height ; ++i) {
            this.addLane(i);
        }

    }

    public void addLane(int i) {
        this.roadLines.add(new LaneInf(this.game, i));
    }

    public boolean isSafe(Case c) {
        return ((LaneInf)this.roadLines.get(c.ord)).isSafe(c);
    }

    public boolean isWinningPosition(Case c) {
        return false;
    }

    public void update() {
        Iterator var2 = this.roadLines.iterator();

        while(var2.hasNext()) {
            LaneInf lane = (LaneInf)var2.next();
            lane.update();
        }

    }

    public void addLane() {
        this.addLane(this.roadLines.size());
    }
}
