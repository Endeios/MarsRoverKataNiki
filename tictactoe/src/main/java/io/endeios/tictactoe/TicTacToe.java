package io.endeios.tictactoe;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicTacToe {

    private static final Logger logger = LoggerFactory.getLogger(TicTacToe.class);

    public static void main(String[] args) {
        logger.info("Welcome to Tick tack toe");
    }

    public Player currentPlayer() {
        return Player.X;
    }

    public void play(int column, int row) {

    }

    public Player getStatusForPosition(int i, int i1) {
        return Player.X;
    }
}
