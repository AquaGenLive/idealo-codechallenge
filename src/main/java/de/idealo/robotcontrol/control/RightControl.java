package de.idealo.robotcontrol.control;

import de.idealo.robotcontrol.grid.Robot;
import lombok.Data;

@Data
public class RightControl implements Control {
    @Override
    public void move(Robot robot) {
        switch (robot.getHeading()) {
            case NORTH:
                robot.setHeading(Robot.Heading.EAST);
                break;
            case EAST:
                robot.setHeading(Robot.Heading.SOUTH);
                break;
            case SOUTH:
                robot.setHeading(Robot.Heading.WEST);
                break;
            case WEST:
                robot.setHeading(Robot.Heading.NORTH);
                break;
        }
    }
}
