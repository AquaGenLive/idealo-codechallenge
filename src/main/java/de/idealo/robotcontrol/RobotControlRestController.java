package de.idealo.robotcontrol;

import de.idealo.robotcontrol.grid.Grid;
import de.idealo.robotcontrol.grid.Position;
import de.idealo.robotcontrol.robot.Robot;
import de.idealo.robotcontrol.ui.ControlFormElement;
import de.idealo.robotcontrol.ui.FrontendInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RobotControlRestController {

    @PostMapping("/robot/movement")
    public Robot robotMovements(@RequestBody FrontendInput frontendInput) {
        Robot robot = new Robot(frontendInput.getCurrentPossitionOfRobot(), frontendInput.getCurrentHeadingOfRobot());
        Grid grid = new Grid(5, 5, robot);
        if (!grid.isRobotPositionWithinGrid()) {
            throw new IllegalArgumentException("Robot current position is outside of the grid. Wrong input?");
        }

        return new Robot(new Position(0, 0), Robot.Heading.EAST);
    }
}
