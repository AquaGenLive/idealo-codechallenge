package de.idealo.robotcontrol;

import de.idealo.robotcontrol.grid.Grid;
import de.idealo.robotcontrol.robot.Robot;
import de.idealo.robotcontrol.ui.FrontendInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotControlRestController {

    @PostMapping("/robot/movement")
    public Robot robotMovements(@RequestBody FrontendInput frontendInput) {
        Robot robot = new Robot(frontendInput.getCurrentPossitionOfRobot(), frontendInput.getCurrentHeadingOfRobot());
        Grid grid = new Grid(5, 5, robot);
        if (!grid.isRobotPositionWithinGrid()) {
            throw new IllegalArgumentException("Robot current position is outside of the grid. Wrong input?");
        }

        grid.moveRobot(frontendInput.getControls());

        return grid.getRobot();
    }
}
