package com.example.ia.hash;

public class HashPosition {

    public int x, y;

    public HashPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public HashPosition(HashPosition position) {
        this.x = position.x;
        this.y = position.y;
    }
}
