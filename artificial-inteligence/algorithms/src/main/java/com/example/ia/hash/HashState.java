package com.example.ia.hash;

import br.ufu.ml.ia.Player;
import br.ufu.ml.ia.State;

public class HashState implements State {

    public final static char nullChar = '\u0000';
    private char[][] state;
    private int utility = Integer.MIN_VALUE;

    public HashState() {
        this.state = new char[3][3];
    }

    public void mark(HashPlayer player, HashPosition position) {
        mark(player.getValue(), position.x, position.y);
    }

    public void mark(HashPlayer player, int x, int y) {
        mark(player.getValue(), x, y);
    }

    public void mark(char value, int x, int y) {
        if (!canMark(x, y)) throw new RuntimeException("You can't mark here!");
        state[x][y] = value;
    }

    public boolean canMark(HashPosition position) {
        return canMark(position.x, position.y);
    }

    public boolean canMark(int x, int y) {
        return state[x][y] == nullChar;
    }

    public int empties() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (canMark(i, j)) count ++;
            }
        }
        return count;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public boolean isTerminal() {
        return getUtility() != Integer.MIN_VALUE;
    }

    public int getUtility() {
        // check horizontals for X and O
        int empties = empties();
        for (int i = 0; i < 3; i++) {
            int countX = 0;
            int countO = 0;
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == 'X') countX++;
                if (state[i][j] == 'O') countO++;
            }
            if (countX == 3) {
                if (empties == 0)
                    return  1;
                return (utility = empties);
            }
            if (countO == 3) {
                if (empties == 0)
                    return  -1;
                return (utility = -1 * empties);
            }
        }

        // check vertical for X and O
        for (int i = 0; i < 3; i++) {
            int countX = 0;
            int countO = 0;
            for (int j = 0; j < 3; j++) {
                if (state[j][i] == 'X') countX++;
                if (state[j][i] == 'O') countO++;
            }
            if (countX == 3) {
                if (empties == 0)
                    return  1;
                return (utility = empties);
            }
            if (countO == 3) {
                if (empties == 0)
                    return  -1;
                return (utility = -1 * empties);
            }
        }

        // check main diagonal for X and O
        int countDX = 0;
        int countDO = 0;
        for (int i = 0; i < 3; i++) {
            if (state[i][i] == 'X') countDX++;
            if (state[i][i] == 'O') countDO++;
        }
        if (countDX == 3) {
            if (empties == 0)
                return  1;
            return (utility = empties);
        }
        if (countDO == 3) {
            if (empties == 0)
                return  -1;
            return (utility = -1 * empties);
        }

        // restart counters
        countDX = 0;
        countDO = 0;

        // check secondary diagonal X and O
        for (int i = 0; i < 3; i++) {
            if (state[i][2 - i] == 'X') countDX++;
            if (state[i][2 - i] == 'O') countDO++;
        }
        if (countDX == 3) {
            if (empties == 0)
                return  1;
            return (utility = empties);
        }
        if (countDO == 3) {
            if (empties == 0)
                return  -1;
            return (utility = -1 * empties);
        }

        if (empties == 0)  return (utility = 0);
        return Integer.MIN_VALUE;
    }

    public char getValue(int x, int y) {
        return state[x][y];
    }

    public char getValue(HashPosition position) {
        return state[position.x][position.y];
    }

    @Override
    public boolean equals(State s1) {
        HashState s = (HashState) s1;
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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = state[i][j];
                if (c == nullChar)
                    builder.append(" ");
                else
                    builder.append(c);
                if (j != 2)
                    builder.append("|");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public State clone() {
        HashState clone = new HashState();
        clone.state = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                clone.state[i][j] = this.state[i][j];
            }
        }
        return clone;
    }
}
