package br.ufu.ml.ia;

import java.util.List;
import java.util.Stack;

public class DFS extends Algorithm {

    private final int m, d;

    public DFS(int m, int d) {
        // DO NOT ANYTHING WITH AGENT HERE!!
        // BECAUSE IT'S PASSED TO THIS OBJECT IN OTHER STAGE!!
        // NOW, IT'S IS NULL!!!
        this.m = m;
        this.d = d;
    }

    @Override
    protected Stack<State> search() {
        setup();
        long height = d;
        Stack<Node<NodeData>> stack = new Stack<>();      // aux search stack
        Node<NodeData> auxNode;                          // aux node
        stack.add(getRoot());

        if (isObjective(getRoot())) {
            return makeResult(getRoot());
        }

        getRoot().setVisited(true);

        while (!stack.isEmpty()) {
            auxNode = stack.peek();
            if (auxNode.getChildren().size() == 0) {
                expand(auxNode); // expande todos filhos
            }

            for (Node<NodeData> child : auxNode.getChildren()) {
                if (child.isVisited() && height == d)
                    continue;

                child.setVisited(true);

                if (isObjective(child)) {
                    return makeResult(child);
                }
                if (child.getHeight() < height) {
                    stack.add(child);
                    break;
                }
            }

            if (auxNode.getData().getState().equals(stack.peek().getData().getState())) {
                stack.pop();
                if (stack.empty()) {
                    stack.add(getRoot());
                    height = m;
                }
            }
        }
        return null;
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
    protected Stack<State> makeResult(Node<NodeData> node) {
        Stack<State> solutionQueue = new Stack<>();

        while (node != null) {
            solutionQueue.add(node.getData().getState());
            node = node.getParent();
        }
        return solutionQueue;
    }

    @Override
    protected void expand(Node<NodeData> parent) {
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
