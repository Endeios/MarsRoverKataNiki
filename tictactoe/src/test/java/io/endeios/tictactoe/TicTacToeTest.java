package io.endeios.tictactoe;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    @Test
    void canBeCreated() {
        TicTacToe ticTacToe = new TicTacToe();
        assertNotNull(ticTacToe);
    }

    @Test
    void playerXIsTheFirstToStart() {
        TicTacToe ticTacToe = new TicTacToe();
        assertSame(Player.X, ticTacToe.currentPlayer());
    }

    @Test
    void playerCanPlayAPosition() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play(0, 0);
        assertEquals(Player.X, ticTacToe.getStatusForPosition(0, 0));
    }
}
