package com.example.ia.eightPuzzle;


import br.ufu.ml.ia.Action;
import br.ufu.ml.ia.ActionException;

import java.util.ArrayList;
import java.util.List;

public final class EightPuzzleActions {

    private static EightPuzzleActions actions;
    private final List<Action> actionList;

    private EightPuzzleActions() {
        actionList = new ArrayList<>();
        actionList.add(this.moveToDown);
        actionList.add(this.moveToUp);
        actionList.add(this.moveToLeft);
        actionList.add(this.moveToRight);
    }

    public final Action moveToLeft = curState -> {
        EightPuzzleState result = EightPuzzleState.clone((EightPuzzleState) curState);

        if (!result.isLeftPossible()) {
            throw new ActionException("You already is on left possible!");
        }

        result.setLeft();
        return result;
    };

    public final Action moveToRight = stateBefore -> {
        EightPuzzleState result = EightPuzzleState.clone((EightPuzzleState) stateBefore);

        if (!result.isRightPossible()) {
            throw new ActionException("You already is on right possible!");
        }

        result.setRight();
        return result;
    };

    public final Action moveToUp = stateBefore -> {
        EightPuzzleState result = EightPuzzleState.clone((EightPuzzleState) stateBefore);

        if (!result.isUpPossible()) {
            throw new ActionException("You already is on up possible!");
        }

        result.setUp();
        return result;
    };

    public final Action moveToDown = stateBefore -> {
        EightPuzzleState result = EightPuzzleState.clone((EightPuzzleState) stateBefore);

        if (!result.isDownPossible()) {
            throw new ActionException("You already is on down possible!");
        }

        result.setDown();
        return result;
    };

    public static EightPuzzleActions getInstance() {
        if (actions == null) {
            synchronized (EightPuzzleActions.class) {
                if (actions == null) {
                    actions = new EightPuzzleActions();
                }
            }
        }

        return actions;
    }

    public List<Action> getActionList() {
        return actionList;
    }
}
