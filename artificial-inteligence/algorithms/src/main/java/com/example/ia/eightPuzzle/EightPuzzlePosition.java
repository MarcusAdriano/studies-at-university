package com.example.ia.eightPuzzle;

public final class EightPuzzlePosition {

    public int x, y;

    public EightPuzzlePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public EightPuzzlePosition() {
    }

    public EightPuzzlePosition(EightPuzzlePosition position) {
        this.x = position.x;
        this.y = position.y;
    }
}
