package com.example.ia.eightPuzzle;


import br.ufu.ml.ia.AStar;
import br.ufu.ml.ia.State;
import java.util.*;

public class Runner {

    public static void main(String[] args) throws Exception {
        // fetch objective list
        List<State> objectiveList = new LinkedList<>(
                Collections.singletonList(EightPuzzleState.getObjectiveState()));

        EightPuzzleState bookInitialState =
                new EightPuzzleState(new int[][]{{8,7,6},{5,4,3},{2,1,0}});

//        EightPuzzleState bookInitialState =
//                new EightPuzzleState(new int[][]{{7,2,4},{5,0,6},{8,3,1}});

        EightPuzzleAgent agent = new EightPuzzleAgent(
                objectiveList,
                bookInitialState);

        // try solve with A*
        agent.setAlgorithm(new AStar());
        agent.solve();

        if (agent.isSolved()) {
            Stack<State> solution = agent.getSolution();
            System.out.printf("Jogadas necessárias: %d\n", solution.size());
            while (!solution.isEmpty()) {
                System.out.println(solution.pop());
            }
        } else {
            System.out.println("Não foi encontrada uma solução!");
        }
    }
}
