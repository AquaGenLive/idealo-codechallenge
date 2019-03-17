package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.ui.MovementInstructions;
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

    public Robot(MovementInstructions movementInstructions) {
        this.heading = movementInstructions.getCurrentHeadingOfRobot();
        this.position = movementInstructions.getCurrentPositionOfRobot();
    }

    /**
     * @return start position is x=0; y=0; heading=EAST.
     */
    public static Robot robotOnStartPosition() {
        return new Robot(new Position(0, 0), Heading.EAST);
    }


    public boolean isOnPosition(Position position) {
        return this.position.equals(position);
    }
}
