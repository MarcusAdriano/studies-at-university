package com.example.ia.hash;

import br.ufu.ml.ia.Action;
import br.ufu.ml.ia.ActionException;

import java.util.ArrayList;

public class HashActions {

    private static HashActions actions;

    public static HashActions getInstance() {
        if (actions == null) {
            synchronized (HashActions.class) {
                actions = new HashActions();
            }
        }
        return actions;
    }

    private HashActions() { }

    public ArrayList<HashState> possibilities(char value, HashState state) {
        ArrayList<HashState> stateList = new ArrayList<>(state.empties());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state.canMark(i, j)) {
                    stateList.add(apply(value, state, i, j));
                }
            }
        }
        return stateList;
    }

    private HashState apply(char value, HashState state, int x, int y) {
         Action action = s1 -> {
            HashState sFinal = (HashState) s1.clone();
             sFinal.mark(value, x, y);
             return sFinal;
         };

        try {
            return ((HashState) action.execute(state));
        } catch (ActionException ignore) {
            // we only perform actions where can do anything!
            // otherwise a Runtime exception is throw
        }
        return null;
    }
}
