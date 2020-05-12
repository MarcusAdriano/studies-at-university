package br.ufu.ml.ia;

import br.ufu.util.Executors;
import br.ufu.util.OrderedList;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class AStar extends Algorithm {

    private final LinkedList<State> visitedList = new LinkedList<>();
    private final OrderedList<Node<NodeData>> list = new OrderedList<>();
    private final Stack<State> result = new Stack<>();

    private int countNodes;

    // Used for multi thread
    private final Object lock = new Object();
    private final Object listLock = new Object();
    private final Object visitedLock = new Object();
    private final Object auxLock = new Object();
    private int n = 10;
    // end multi thread

    private void aSearchSingleThread() {
        Node<NodeData> auxNode;
        System.err.printf("Run A* at %s\n", Thread.currentThread().getName());

        while (result.isEmpty() && !list.isEmpty()) {
            // retrieve the first element from list
            // and remove it, because it's the
            // lower cost f(n)
            auxNode = list.pollFirst();

            assert auxNode != null;
            // System.out.println(auxNode.getData().getState().toString());

            if (isObjective(auxNode)) {
                result.addAll(makeResult(auxNode));
                break;
            }

            if (auxNode.getChildren().size() == 0) {
                expand(auxNode);
            }

            visitedList.add(auxNode.getData().getState());

            for(Node<NodeData> item : auxNode.getChildren()) {
                // verify if the item was visited
                if (visitedList.contains(item.getData().getState()) || list.contains(item)) {
                    continue;
                }

                // otherwise, add it on the list to be visited
                int dist = getAgent().h(item.getData().getState());
                item.getData().setCoast(item.getHeight() + dist);

                list.add(item);
            }

            if (auxNode.getHeight() > 0 && auxNode.getHeight() % n == 0) {
                System.err.printf("Node on height %d was reached. " +
                                    "There are %d node(s) on list to be visited! Next node has f(n) = %d.\n",
                        n, list.size(), list.peekFirst().getData().getCoast());
                n += 10;
            }
        }
    }

    private void aSearchMultiThread() {
        Node<NodeData> auxNode;
        System.err.printf("Run A* at %s\n", Thread.currentThread().getName());

        while (result.isEmpty()) {
            // retrieve the first element from list
            // and remove it, because it's the
            // lower cost f(n)
            synchronized (listLock) {
                while (list.isEmpty()) {
                    try {
                        listLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                auxNode = list.pollFirst();
            }

            assert auxNode != null;
            // System.out.println(auxNode.getData().getState().toString());

            if (isObjective(auxNode)) {
                synchronized (lock) {
                    result.addAll(makeResult(auxNode));
                    lock.notify();
                }
                break;
            }

            if (auxNode.getChildren().size() == 0) {
                synchronized (auxLock) {
                    expand(auxNode);
                }
            }

            synchronized (visitedLock) {
                visitedList.add(auxNode.getData().getState());
            }

            for(Node<NodeData> item : auxNode.getChildren()) {
                // verify if the item was visited
                if (visitedList.contains(item.getData().getState()) || list.contains(item)) {
                    continue;
                }

                // otherwise, add it on the list to be visited
                int dist = getAgent().h(item.getData().getState());
                item.getData().setCoast(item.getHeight() + dist);

                synchronized (listLock) {
                    list.add(item);
                    countNodes ++;
                }
            }

            synchronized (listLock) {
                listLock.notifyAll();
            }

            synchronized (lock) {
                if (auxNode.getHeight() > 0 && auxNode.getHeight() % n == 0) {
                    System.err.printf("Node on height %d was reached. " +
                                    "There are %d node(s) on list to be visited! Next node has f(n) = %d.\n",
                            n, list.size(), list.peekFirst().getData().getCoast());
                    n += 10;
                }
                if (countNodes >= 181400) {
                    return;
                }
            }
        }
    }

    private void clear() {
        list.clear();
        visitedList.clear();
        countNodes = 1;
    }

    private void runMultiThread() {
        clear();
        expand(getRoot());
        list.add(getRoot());
        list.addAll(getRoot().getChildren());

        for (int i = 0; i < 4; i++)
            Executors.getInstance().getThreadPool().execute(this::aSearchMultiThread);

        Executors.getInstance().getThreadPool().shutdown();

        while (result.isEmpty()) {
            try {
                synchronized (lock) {
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void runSingleThread() {
        clear();
        list.add(getRoot());
        aSearchSingleThread();
    }

    @Override
    protected Stack<State> search() {
        // show initial state
        System.err.println("Initial State: \n" + getRoot().getData().getState());
        long initialTime = new Date().getTime();

        runMultiThread();

        System.err.printf("Time in seconds: %d\n",
                (new Date().getTime() - initialTime) / 1000);
        System.err.println("Total de nós gerados: " + countNodes);
        return result;
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
