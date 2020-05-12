package com.example.ia.eightPuzzle;

import br.ufu.ml.ia.*;

import java.util.List;

import static java.lang.Math.abs;
import static com.example.ia.eightPuzzle.EightPuzzleState.findTile;

public final class EightPuzzleAgent extends Agent {

    private List<Action> actionList;

    public EightPuzzleAgent(List<State> objective, EightPuzzleState initialState) {
        super(objective, initialState);
    }

    @Override
    public List<Action> getActionList() {
        if (actionList == null) {
            actionList = EightPuzzleActions.getInstance().getActionList();
        }

        return actionList;
    }

    @Override
    public int h(State n) {
        try {
            return manhattanDistance((EightPuzzleState) n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.h(n);
    }

    private int manhattanDistance(EightPuzzleState state) throws Exception {
        int dist = 0;
        for (int i = 1; i < 9; i++) {
            EightPuzzlePosition o = findTile(i, (EightPuzzleState) getObjective().get(0));
            EightPuzzlePosition p = findTile(i, state);
            dist += abs((o.x - p.x)) +  abs(o.y - p.y);
        }
        return dist;
    }
}
