package br.ufu.ml.ia;

public class NodeData
        implements Comparable<NodeData> {

    private NodeData parentData;
    private State state;
    private Action action;
    private int coast;

    public void setCoast(int coast) {
        this.coast = coast;
    }

    private NodeData() {
    }

    public NodeData(NodeData parent, State state) {
        this.action = null;
        this.parentData = parent;
        this.coast = parent.getCoast() + 1;
        this.state = state;
    }

    public NodeData(NodeData parent, Action action) throws ActionException {
        this(parent, action, 1);
    }

    public NodeData(NodeData parent, Action action, int coast) throws ActionException {
        this.parentData = parent;
        this.action = action;
        this.state = action.execute(parent.state);
        this.coast = parent.coast + coast;
    }

    public static NodeData newRoot(State initialState) {
        NodeData n = new NodeData();
        n.coast = 0;
        n.state = initialState;
        n.action = null;
        n.parentData = null;
        return n;
    }

    public NodeData generateChild(Action action) throws ActionException {
        return new NodeData(this.parentData, action);
    }

    public State getState() {
        return state;
    }

    public NodeData getParentData() {
        return parentData;
    }

    public Action getAction() {
        return action;
    }

    public int getCoast() {
        return coast;
    }

    @Override
    public int compareTo(NodeData o) {
        if (o.coast == coast) return 0;
        return coast < o.coast ? -1 : 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NodeData)) return false;
        NodeData data = (NodeData) obj;
        if (data.action.equals(this.action) &&
                data.state.equals(this.state))
            return true;
        else
            return false;
    }
}