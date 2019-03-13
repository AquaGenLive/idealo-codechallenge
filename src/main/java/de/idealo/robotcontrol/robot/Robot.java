package de.idealo.robotcontrol.robot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {

    public enum Heading {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }

    private int positionX;
    private int positionY;
    private Heading heading;
    private static final String NAME = "Charly";

}
