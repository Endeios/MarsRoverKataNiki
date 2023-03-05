package io.endeios.tictactoe;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

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
}
