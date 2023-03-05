package io.endeios.tictactoe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe ticTacToe;

    Logger logger = LoggerFactory.getLogger(TicTacToeTest.class);

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void canBeCreated() {
        assertNotNull(ticTacToe);
    }

    @Test
    void playerXIsTheFirstToStart() {
        assertSame(Player.X, ticTacToe.currentPlayer());
    }

    @Test
    void playerCanPlayAPosition() {
        ticTacToe.play(0, 0);
        assertEquals(Player.X, ticTacToe.getStatusForPosition(0, 0));
    }

    @Test
    void playerOPlaysAfterX() {
        ticTacToe.play(0, 0);
        assertSame(Player.O, ticTacToe.currentPlayer());
    }

    @Test
    void playersCantPlayTwiceSamePosition() {
        ticTacToe.play(0, 0);
        assertThrows(IllegalMoveException.class, () -> ticTacToe.play(0, 0));
    }

    @Test
    void nullGameOne() {
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(2, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 1);
        ticTacToe.play(0, 2);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 2);
        logger.info("{}", ticTacToe);
        assertSame(ticTacToe.getStatus(), GameStatus.PLAYER_X_WINS);
    }
}
