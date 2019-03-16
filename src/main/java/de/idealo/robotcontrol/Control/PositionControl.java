package de.idealo.robotcontrol.Control;

import de.idealo.robotcontrol.robot.Robot;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PositionControl implements Control {
    private int x;
    private int y;
    private Robot.Heading heading;
}
