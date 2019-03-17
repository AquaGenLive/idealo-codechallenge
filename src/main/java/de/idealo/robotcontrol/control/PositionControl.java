package de.idealo.robotcontrol.control;

import de.idealo.robotcontrol.grid.Position;
import de.idealo.robotcontrol.grid.Robot;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PositionControl implements Control {
    private int x;
    private int y;
    private Robot.Heading heading;

    @Override
    public void move(Robot robot) {
        robot.setPosition(new Position(x, y));
        robot.setHeading(heading);
    }
}
