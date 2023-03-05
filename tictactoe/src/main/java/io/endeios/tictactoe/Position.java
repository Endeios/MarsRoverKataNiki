package io.endeios.tictactoe;

public enum Position {
    X, O, EMPTY;

    @Override
    public String toString() {
        return name();
    }
}
