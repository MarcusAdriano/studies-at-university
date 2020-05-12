package br.ufu.ml.ia;

import java.util.Stack;

public abstract class Algorithm {

	private Agent agent;
    private Node root;

    protected abstract Stack<State> search();
    protected abstract void expand(Node<NodeData> parent);
    protected abstract Stack<State> makeResult(Node<NodeData> node);
    protected abstract boolean isObjective(Node<NodeData> node);

    /**
     * Called when user decide to solve a problem!
     */
    protected abstract void setup();

    public final Agent getAgent() {
        return agent;
    }

    /*package*/ final void setAgent(Agent agent) {
        this.agent = agent;
    }

    public final Node<NodeData> getRoot() {
        return this.root;
    }

    /*package*/ final void setRoot(Node root) {
        this.root = root;
    }
}
