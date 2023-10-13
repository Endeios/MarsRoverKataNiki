package org.rover;

import static org.rover.Orientation.*;

public class MarsRover {

    private final State state = new State(0, 0, NORTH);

    public State drive(String m) {
        for (char ch : m.toCharArray()) {
            if (ch == 'l') {
                if (faces(NORTH))
                    state.setOrientation(WEST);
                else if (faces(WEST))
                    state.setOrientation(SOUTH);
                else if (faces(SOUTH))
                    state.setOrientation(EAST);

            }
            if (ch == 'r') {
                state.setOrientation(EAST);
            }
            if (ch == 'm') {
                if (faces(WEST))
                    state.setX(state.getX() - 1);
                if (faces(NORTH))
                    state.setY(state.getY() + 1);
                if (faces(EAST))
                    state.setX(state.getX() + 1);
            }
        }
        return state;
    }

    private boolean faces(Orientation orientation) {
        return state.getOrientation().equals(orientation);
    }
}
