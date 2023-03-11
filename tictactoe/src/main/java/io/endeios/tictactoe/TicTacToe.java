package io.endeios.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiPredicate;

import static io.endeios.tictactoe.Position.EMPTY;

/**
 * Represents a single game
 */
public class TicTacToe {

    private final Position[][] gameBoard = new Position[3][3];
    private Player currentPlayer;

    private static final Logger logger = LoggerFactory.getLogger(TicTacToe.class);
    private GameStatus gameStatus;

    public TicTacToe() {
        this.currentPlayer = Player.X;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = EMPTY;
            }
        }
        gameStatus = GameStatus.PLAYING;
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
        checkWinner();
        if (getStatus() == GameStatus.PLAYING)
            switchPlayer();
    }

    private void checkWinner() {
        if (hasConsecutiveThreeSymbols(currentPlayer))
            wins(currentPlayer);
    }

    private void wins(Player currentPlayer) {
        gameStatus = switch (currentPlayer) {
            case X -> GameStatus.PLAYER_X_WINS;
            case O -> GameStatus.PLAYER_O_WINS;
        };
    }

    private boolean hasConsecutiveThreeSymbols(Player currentPlayer) {
        return rowsAre(currentPlayer.symbol) || columnsAre(currentPlayer.symbol) || diagonalsAre(currentPlayer.symbol);
    }

    private boolean diagonalsAre(Position symbol) {
        return
                gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol ||
                        gameBoard[2][0] == symbol && gameBoard[1][1] == symbol && gameBoard[0][2] == symbol;
    }

    private boolean columnsAre(Position symbol) {
        return aligned(symbol, this::columnIs);
    }

    private boolean aligned(Position symbol, BiPredicate<Integer, Position> predicate) {
        for (int i = 0; i < 3; i++) {
            if (Boolean.TRUE.equals(predicate.test(i, symbol))) {
                return true;
            }
        }
        return false;
    }

    private boolean columnIs(int colNum, Position symbol) {
        return gameBoard[0][colNum] == symbol && gameBoard[1][colNum] == symbol && gameBoard[2][colNum] == symbol;
    }

    private boolean rowsAre(Position symbol) {
        return aligned(symbol, this::rowIs);
    }

    private boolean rowIs(int rowNum, Position symbol) {
        return gameBoard[rowNum][0] == symbol && gameBoard[rowNum][1] == symbol && gameBoard[rowNum][2] == symbol;
    }

    private void switchPlayer() {
        currentPlayer = switch (currentPlayer) {
            case O -> Player.X;
            case X -> Player.O;
        };
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
        return gameStatus;
    }
}
