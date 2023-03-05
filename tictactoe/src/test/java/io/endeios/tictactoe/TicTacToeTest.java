package io.endeios.tictactoe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe ticTacToe;

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
    void playersCantCPlayTwiceSamePosition() {
        ticTacToe.play(0, 0);
        assertThrows(IllegalMoveException.class, () -> ticTacToe.play(0, 0));
    }
}
