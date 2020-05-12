package com.example.ia.vacuum;

import br.ufu.ml.ia.BFS;
import br.ufu.ml.ia.DFS;
import br.ufu.ml.ia.State;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Runner {

    public static void main(String[] args) throws Exception {
        List<State> vacuumObjective = new LinkedList<>();
        vacuumObjective.add(new VacuumState(true, false, false, false));
        vacuumObjective.add(new VacuumState(false, true, false, false));

        VacuumState initialState = new VacuumState(true, false, true, true);
        VacuumAgent agent = new VacuumAgent(vacuumObjective, initialState);
        //agent.setAlgorithm(new BFS());
        agent.setAlgorithm(new DFS(3,2));

        agent.solve();

        if (agent.isSolved()) {
            Stack<State> result = agent.getSolution();
            State t;

            while (!result.isEmpty()) {
                t = result.pop();
                System.out.println(t.toString());
            }
        }
    }

}
