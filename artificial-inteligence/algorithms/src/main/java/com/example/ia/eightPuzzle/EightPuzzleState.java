package com.example.ia.eightPuzzle;

import br.ufu.ml.ia.State;

import java.util.ArrayList;
import java.util.Random;

public final class EightPuzzleState implements State {

    private EightPuzzlePosition emptyPosition;
    private int[][] state;

    public EightPuzzleState(int[][] state) {
        this.state = state;
        try {
            this.emptyPosition = findTile(0, this);
        } catch (Exception ignore) {

        }
    }

    public EightPuzzleState() {
        this.state = new int[3][3];
        this.emptyPosition = new EightPuzzlePosition();
    }

    private int getX (){
        return emptyPosition.x;
    }

    private int getY(){
        return emptyPosition.y;
    }

    void setLeft() {
        int aux = this.state[getX()-1][getY()];
        this.state[getX()-1][getY()] = this.state[getX()][getY()];
        this.state[getX()][getY()] = aux;
        this.emptyPosition.x--;
    }

    void setRight() {
        int aux = this.state[getX()+1][getY()];
        this.state[getX()+1][getY()] = this.state[getX()][getY()];
        this.state[getX()][getY()] = aux;
        this.emptyPosition.x++;
    }

    void setUp() {
        int aux = this.state[getX()][getY()-1];
        this.state[getX()][getY()-1] = this.state[getX()][getY()];
        this.state[getX()][getY()] = aux;
        this.emptyPosition.y--;
    }

    void setDown() {
        int aux = this.state[getX()][getY()+1];
        this.state[getX()][getY()+1] = this.state[getX()][getY()];
        this.state[getX()][getY()] = aux;
        this.emptyPosition.y++;
    }

    public boolean isLeftPossible() {
        return getX() == 1 || getX() == 2;
    }

    public boolean isRightPossible() {
        return getX() == 0 || getX() == 1;
    }

    public boolean isUpPossible() {
        return getY() == 1 || getY() == 2;
    }

    public boolean isDownPossible() {
        return getY() == 0 || getY() == 1;
    }

    @Override
    public boolean equals(State s1) {
        EightPuzzleState s = (EightPuzzleState) s1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.state[i][j] != this.state[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public State clone() {
        return clone(this);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int g = state[i][j];
                if (g == 0)
                    builder.append("-");
                else
                    builder.append(g);
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static EightPuzzleState clone(EightPuzzleState s1) {
        EightPuzzleState newState = new EightPuzzleState();
        newState.state = new int[3][3];
        newState.emptyPosition = new EightPuzzlePosition(s1.emptyPosition);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                newState.state[i][j] = s1.state[i][j];

        return newState;
    }

    public static EightPuzzleState getInitialState() {
        EightPuzzleState iniState = new EightPuzzleState();
        Random rand = new Random();

        ArrayList<Integer> numbers = new ArrayList<>(8);
        for (int i = 1; i <= 8; i++) numbers.add(i);

        iniState.emptyPosition.x = rand.nextInt(3);
        iniState.emptyPosition.y = rand.nextInt(3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (iniState.emptyPosition.x == i && iniState.emptyPosition.y == j) continue;
                int position = rand.nextInt(numbers.size());
                iniState.state[i][j] = numbers.remove(position);
            }
        }

        return iniState;
    }

    public static EightPuzzleState getObjectiveState() {
        EightPuzzleState objState = new EightPuzzleState();
        objState.state = new int[][]{{0,1,2},{3,4,5},{6,7,8}};
        objState.emptyPosition = new EightPuzzlePosition(0,0);
        return objState;
    }

    public static EightPuzzlePosition findTile(int x, EightPuzzleState n)
            throws Exception {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (n.state[i][j] == x)
                    return new EightPuzzlePosition(i, j);
            }
        }
        throw new Exception(String.format("%d is out of bound [1,8]!", x));
    }

    private static boolean isSoluble(EightPuzzleState n) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count += countSolubleFor(n.state[i][j], n, new EightPuzzlePosition(i, j));
            }
        }
        return count % 2 == 0;
    }

    private static int countSolubleFor(int value, EightPuzzleState n, EightPuzzlePosition position) {
        int count = 0;
        for (int i = position.x; i < 3; i++) {
            for (int j = position.y; j < 3; j++) {
                if (value < n.state[i][j]) {
                    count += n.state[i][j];
                }
            }
        }
        return count;
    }
}
