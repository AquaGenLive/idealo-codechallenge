package de.idealo.robotcontrol.robot;

import de.idealo.robotcontrol.grid.Position;
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

    private Position position;
    private Heading heading;


    public boolean isRobotOnPosition(Position position) {
        return this.position.equals(position);
    }

}
