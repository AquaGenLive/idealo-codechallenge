package de.idealo.robotcontrol.ui;

import de.idealo.robotcontrol.grid.Position;
import de.idealo.robotcontrol.grid.Robot;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FrontendInput {
    private Position currentPossitionOfRobot;
    private Robot.Heading currentHeadingOfRobot;
    private List<ControlFormElement> controls;
}
