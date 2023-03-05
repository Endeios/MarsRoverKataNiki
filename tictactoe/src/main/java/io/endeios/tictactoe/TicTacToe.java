package io.endeios.tictactoe;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicTacToe {

    Player currentPlayer;

    private static final Logger logger = LoggerFactory.getLogger(TicTacToe.class);

    public static void main(String[] args) {
        logger.info("Welcome to Tick tack toe");
    }

    public TicTacToe() {
        this.currentPlayer = Player.X;
    }

    public Player currentPlayer() {
        return currentPlayer;
    }

    public void play(int column, int row) {
        switchPlayer();
    }

    private void switchPlayer() {
        if (currentPlayer == Player.X) {
            currentPlayer = Player.O;
        } else {
            currentPlayer = Player.X;
        }
    }

    public Player getStatusForPosition(int column, int row) {
        return Player.X;
    }
}
