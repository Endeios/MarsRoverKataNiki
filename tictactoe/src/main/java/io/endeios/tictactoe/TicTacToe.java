package io.endeios.tictactoe;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.endeios.tictactoe.Position.EMPTY;

public class TicTacToe {

    Player currentPlayer;
    Position[][] gameBoard = new Position[3][3];

    private static final Logger logger = LoggerFactory.getLogger(TicTacToe.class);

    public TicTacToe() {
        this.currentPlayer = Player.X;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = EMPTY;
            }
        }
    }

    public Player currentPlayer() {
        logger.debug("Current player is {}", currentPlayer);
        return currentPlayer;
    }

    public void play(int column, int row) {
        logger.debug("{} plays {},{}", currentPlayer, column, row);
        if (gameBoard[column][row] == EMPTY) {
            gameBoard[column][row] = currentPlayer.symbol;
        } else {
            throw new IllegalMoveException("Player " + currentPlayer + " cannot occupy position " + row + "," + column);
        }
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
