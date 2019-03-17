package de.idealo.robotcontrol.ui;

import de.idealo.robotcontrol.grid.Position;
import de.idealo.robotcontrol.grid.Robot;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MovementInstructions {
    private Position currentPositionOfRobot;
    private Robot.Heading currentHeadingOfRobot;
    private List<ControlFormElement> controls;
}
