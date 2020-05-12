package br.ufu.ml.ia;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFS extends Algorithm {

    @Override
    protected Stack<State> search() {
        Queue<Node<NodeData>> queue = new LinkedList<>();      // aux search queue
        Node<NodeData> auxNode;                                     // aux node
        queue.add(getRoot());

        if (isObjective(getRoot())) {
            return makeResult(getRoot());
        }

        getRoot().setVisited(true);

        while (!queue.isEmpty()) {
            auxNode = queue.remove();

            if (auxNode.getChildren().size() == 0) {
                expand(auxNode);
            }

            for (Node<NodeData> child : auxNode.getChildren()) {
                if (child.isVisited()) continue;
                child.setVisited(true);

                if (isObjective(child)) {
                    return makeResult(child);
                }

                queue.add(child);
            }
        }
        return null;
    }

    @Override
    protected Stack<State> makeResult(Node<NodeData> node) {
        Stack<State> solutionQueue = new Stack<>();

        while (node != null) {
            solutionQueue.add(node.getData().getState());
            node = node.getParent();
        }
        return solutionQueue;
    }

    @Override
    protected boolean isObjective(Node<NodeData> node) {
        boolean partialTest;
        for (State state : getAgent().getObjective()) {
            partialTest = state.equals(node.getData().getState());
            if (partialTest) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void expand(Node<NodeData> parent) {
        List<Action> actionList = getAgent().getActionList();

        for (Action action : actionList) {
            NodeData childData;
            try {
                childData = new NodeData(parent.getData(), action);
                parent.addChild(childData);
            } catch (ActionException ignore) {

            }
        }
    }

    @Override
    protected void setup() {
        // setup root for tree
        NodeData rootData = NodeData.newRoot(getAgent().getInitialState());

        // tree
        setRoot(new Node<>(rootData));
    }


}
