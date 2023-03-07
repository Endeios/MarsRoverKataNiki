package io.endeios.tictactoe;

/**
 * Represents the players and their respective symbols
 */
public enum Player {
    X(Position.X), O(Position.O);

    final Position symbol;

    Player(Position position) {
        symbol = position;
    }

    @Override
    public String toString() {
        return "Player " + name();
    }
}
