package com.example.ia.vacuum;

import br.ufu.ml.ia.Action;
import br.ufu.ml.ia.Agent;
import br.ufu.ml.ia.State;

import java.util.List;

public final class VacuumAgent extends Agent {

    private List<Action> actionList;

    public VacuumAgent(List<State> objective, State initialState) {
        super(objective, initialState);
    }

    @Override
    public List<Action> getActionList() {
        if (actionList == null) {
            actionList = VacuumActions.getInstance().getActionList();
        }

        return actionList;
    }
}
