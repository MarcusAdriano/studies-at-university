package com.example.ia.vacuum;

import br.ufu.ml.ia.Action;
import br.ufu.ml.ia.ActionException;

import java.util.ArrayList;
import java.util.List;

public final class VacuumActions {

    private static VacuumActions actions;
    private final List<Action> actionList;

    private VacuumActions() {
        actionList = new ArrayList<>();
        actionList.add(this.cleanLeft);
        actionList.add(this.cleanRight);
        actionList.add(this.moveToLeft);
        actionList.add(this.moveToRight);
    }

    public final Action moveToLeft = curState -> {
        VacuumState result = VacuumState.clone((VacuumState) curState);

        if (result.isLeft()) {
            throw new ActionException("You already is on left!");
        }

        result.setLeft(true);
        result.setRight(false);
        return result;
    };

    public final Action moveToRight = stateBefore -> {
        VacuumState stateAfter = VacuumState.clone((VacuumState) stateBefore);

        if (stateAfter.isRight()) {
            throw new ActionException("You already is on right!");
        }

        stateAfter.setLeft(false);
        stateAfter.setRight(true);
        return stateAfter;
    };

    public final Action cleanLeft = stateBefore -> {
        VacuumState stateAfter = VacuumState.clone((VacuumState) stateBefore);

        if (stateAfter.isLeft()) {
            if (stateAfter.isLeftDirty()) {
                stateAfter.setLeftDirty(false);
            } else {
                throw new ActionException("Left is cleaned!");
            }
            return stateAfter;
        } else {
            throw new ActionException("You need stay on left to clean it!");
        }
    };

    public final Action cleanRight = stateBefore -> {
        VacuumState stateAfter = VacuumState.clone((VacuumState) stateBefore);

        if (stateAfter.isRight()) {
            if (stateAfter.isRightDirty()) {
                stateAfter.setRightDirty(false);
            } else {
                throw new ActionException("Right is cleaned!");
            }
            return stateAfter;
        } else {
            throw new ActionException("You need stay on right to clean it!");
        }
    };

    public static VacuumActions getInstance() {
        if (actions == null) {
            synchronized (VacuumActions.class) {
                if (actions == null) {
                    actions = new VacuumActions();
                }
            }
        }

        return actions;
    }

    public List<Action> getActionList() {
        return actionList;
    }
}
