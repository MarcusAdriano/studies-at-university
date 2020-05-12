package br.ufu.ml.ia;

import com.example.ia.hash.HashActions;
import com.example.ia.hash.HashPlayer;
import com.example.ia.hash.HashState;

import java.util.*;

public class Minimax extends Algorithm {

    private Queue<HashPlayer> hashPlayersQueue = new LinkedList<>();
    private HashState localGame = new HashState();

    public Minimax() {
        int n = new Random().nextInt(2);

        if (n == 1) {
            hashPlayersQueue.add(new HashPlayer('X'));
            hashPlayersQueue.add(new HashPlayer('O'));
        } else {
            hashPlayersQueue.add(new HashPlayer('O'));
            hashPlayersQueue.add(new HashPlayer('X'));
        }
    }

    public boolean isUserTurn() {
        assert hashPlayersQueue.peek() != null;
        return hashPlayersQueue.peek().getValue() != 'O';
    }

    public HashPlayer getPlayerOfTurn() {
        HashPlayer player = hashPlayersQueue.poll();
        hashPlayersQueue.add(player);
        return player;
    }

    private int max(Node<NodeData> node) {
        HashState state = (HashState) node.getData().getState();
        if (state.isTerminal()) return state.getUtility();
        expand(node, 'X');
        int v = Integer.MIN_VALUE;
        for (Node<NodeData> child : node.getChildren()) {
            v = Integer.max(v, min(child));
        }
        return v;
    }

    private int min(Node<NodeData> node) {
        HashState state = (HashState) node.getData().getState();
        if (state.isTerminal()) return state.getUtility();
        expand(node, 'O');
        int v = Integer.MAX_VALUE;
        for (Node<NodeData> child : node.getChildren()) {
            v = Integer.min(v, max(child));
        }
        return v;
    }

    public HashState minimax(Node<NodeData> node) {
        expand(node, 'X');
        Node<NodeData> aux = null;
        int auxU = Integer.MIN_VALUE;
        int min = auxU;
        // search best turn
        for (Node<NodeData> child : node.getChildren()) {
            // get best
            min = min(child);
            if (min >= auxU) {
                auxU = min;
                aux = child;
            }
            //aux.getChildren().clear();
        }

        node.getChildren().clear();
        assert aux != null;
        return (HashState) aux.getData().getState();
    }

    @Override
    protected Stack<State> search() {
        // first turn X
        Scanner scan = new Scanner(System.in);

        System.out.println("Starting the game...");
        System.out.println(localGame);
        while (!localGame.isTerminal()) {
            HashPlayer player = getPlayerOfTurn();
            if (player.getValue() == 'X') {
                localGame = minimax(new Node<>(NodeData.newRoot(localGame)));
            } else {
                // interact with user
                int x, y;
                System.out.print("Insert X: ");
                x = scan.nextInt();
                System.out.print("Insert Y: ");
                y = scan.nextInt();

                localGame.mark(player, x, y);
            }
            System.out.println(localGame);
        }

        return null;
    }

    @Override
    protected void expand(Node<NodeData> parent) {
        throw new RuntimeException("Operation not permited! Use another exapand method!");
    }

    private void expand(Node<NodeData> parent, char player) {
        // retrieve all possibilities
        ArrayList<HashState> childList = HashActions.getInstance()
                .possibilities(player, (HashState) parent.getData().getState());
        // and all possibilities on parent's child
        for (HashState state : childList) {
            parent.addChild(new NodeData(parent.getData(), state));
        }
    }

    @Override
    protected Stack<State> makeResult(Node<NodeData> node) {
        return null;
    }

    @Override
    protected boolean isObjective(Node<NodeData> node) {
        return false;
    }

    @Override
    protected void setup() {
        // setup root for tree
        NodeData rootData = NodeData.newRoot(getAgent().getInitialState());

        // tree
        setRoot(new Node<>(rootData));
    }
}
