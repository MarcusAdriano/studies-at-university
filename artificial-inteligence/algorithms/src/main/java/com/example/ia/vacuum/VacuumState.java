package com.example.ia.vacuum;

import br.ufu.ml.ia.State;

public final class VacuumState implements State {

    public VacuumState(boolean left, boolean right, boolean rightDirty, boolean leftDirty) {
        this.left = left;
        this.right = right;
        this.rightDirty = rightDirty;
        this.leftDirty = leftDirty;
    }

    public VacuumState() {
    }

    private boolean left, right, rightDirty, leftDirty;

    /*package*/ void setLeft(boolean left) {
        this.left = left;
    }

    /*package*/ void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isRightDirty() {
        return rightDirty;
    }

    /*package*/ void setRightDirty(boolean rightDirty) {
        this.rightDirty = rightDirty;
    }

    public boolean isLeftDirty() {
        return leftDirty;
    }

    /*package*/ void setLeftDirty(boolean leftDirty) {
        this.leftDirty = leftDirty;
    }

    @Override
    public boolean equals(State s1) {
        VacuumState s = (VacuumState) s1;
        return this.left == s.left && this.right == s.right &&
                this.leftDirty == s.leftDirty && this.rightDirty == s.rightDirty;
    }

    @Override
    public State clone() {
        return clone(this);
    }

    @Override
    public String toString() {
        String message = "";
        if (isRight()) {
            message += "[ ][X] ";
        } else if (isLeft()) {
            message += "[X][ ] ";
        }

        if (isLeftDirty()) {
            message += "[DIRTY]";
        } else {
            message += "[ ]";
        }

        if (isRightDirty()) {
            message += "[DIRTY]";
        } else {
            message += "[ ]";
        }

        return message;
    }

    public static VacuumState clone(VacuumState s1) {
        VacuumState vacuumState = new VacuumState();
        vacuumState.rightDirty = s1.rightDirty;
        vacuumState.right = s1.right;
        vacuumState.leftDirty = s1.leftDirty;
        vacuumState.left = s1.left;
        return vacuumState;
    }
}
