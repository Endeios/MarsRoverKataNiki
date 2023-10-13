package org.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.rover.Orientation.*;

class MarsRoverTest {

    @Test
    void marsRoverExists() {
        var mr = new MarsRover();
        assertNotNull(mr);
    }

    @Test
    void givenACommandM_whenDrive_thenMoveRover() {
        var mr = new MarsRover();
        var position = mr.drive("m");
        var expectedPosition = new State(0, 1, NORTH);
        assertEquals(expectedPosition, position);
    }

    @Test
    void givenEmptyCommand_whenDrive_thenRoverStays() {
        var mr = new MarsRover();
        var position = mr.drive("");
        assertEquals(new State(0, 0, NORTH), position);
    }

    @Test
    void givenACommandL_whenDrive_thenRotateRover() {
        var mr = new MarsRover();
        var position = mr.drive("l");
        var expectedPosition = new State(0, 0, WEST);
        assertEquals(expectedPosition, position);
    }

    @Test
    void givenACommandMM_whenDrive_thenMoveRover() {
        var mr = new MarsRover();
        var position = mr.drive("mm");
        assertEquals(new State(0, 2, NORTH), position);
    }

    @Test
    void givenACommandMMM_whenDrive_thenMoveRover() {
        var mr = new MarsRover();
        var position = mr.drive("mmm");
        assertEquals(new State(0, 3, NORTH), position);
    }

    @Test
    void givenACommandRM_whenDrive_thenMoveRover() {
        var mr = new MarsRover();
        var position = mr.drive("rm");
        assertEquals(new State(1, 0, EAST), position);
    }

    @Test
    void givenACommandLM_whenDrive_thenMoveRover() {
        var mr = new MarsRover();
        var position = mr.drive("lm");
        assertEquals(new State(-1, 0, WEST), position);
    }

    @Test
    void givenACommandLL_whenDrive_thenMoveRover() {
        var mr = new MarsRover();
        var position = mr.drive("ll");
        assertEquals(new State(0, 0, SOUTH), position);
    }

    @Test
    void givenACommandLLL_whenDrive_thenMoveRover() {
        var mr = new MarsRover();
        var position = mr.drive("lll");
        assertEquals(new State(0, 0, EAST), position);
    }

}