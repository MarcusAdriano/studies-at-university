package com.example.ia.hash;

public class HashPlayer implements br.ufu.ml.ia.Player {

    private final char value;

    public HashPlayer(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
