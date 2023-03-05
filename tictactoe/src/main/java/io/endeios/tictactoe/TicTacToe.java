package io.endeios.tictactoe;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.endeios.tictactoe.Position.EMPTY;

public class TicTacToe {

    private final Position[][] gameBoard = new Position[3][3];
    private Player currentPlayer;

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
            logger.debug("Setting {} in {},{}", currentPlayer, column, row);
            gameBoard[column][row] = currentPlayer.symbol;
        } else {
            logger.error("Cannot set {} in {},{}: the position is occupied", currentPlayer, column, row);
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

    @Override
    public String toString() {

        return "\n" +
                gameBoard[0][0] +
                "|" +
                gameBoard[1][0] +
                "|" +
                gameBoard[2][0] +
                "\n" +
                gameBoard[0][1] +
                "|" +
                gameBoard[1][1] +
                "|" +
                gameBoard[2][1] +
                "\n" +
                gameBoard[0][2] +
                "|" +
                gameBoard[1][2] +
                "|" +
                gameBoard[2][2] +
                "\n";
    }

    public GameStatus getStatus() {
        return GameStatus.PLAYER_X_WINS;
    }
}
