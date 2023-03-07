package io.endeios.tictactoe;

/**
 * Thrown when a player tries to play
 * an invalid move
 */
public class IllegalMoveException extends RuntimeException {
    public IllegalMoveException(String message) {
        super(message);
    }
}
