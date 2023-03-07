package io.endeios.tictactoe;

/**
 * Represents the state of a single
 * position in the board.
 * A position will be EMPTY
 * if no player claimed it,
 * amd it will carry a symbol otherwise
 */
public enum Position {
    X, O, EMPTY;

    @Override
    public String toString() {
        return name();
    }
}
