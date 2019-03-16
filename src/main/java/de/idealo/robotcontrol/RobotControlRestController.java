package de.idealo.robotcontrol;

import de.idealo.robotcontrol.grid.Grid;
import de.idealo.robotcontrol.grid.OutOfGridException;
import de.idealo.robotcontrol.grid.Robot;
import de.idealo.robotcontrol.ui.FrontendInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RobotControlRestController {

    private final Logger logger = LoggerFactory.getLogger(RobotControlRestController.class);

    @PostMapping("/robot/movement")
    public Robot robotMovements(@RequestBody FrontendInput frontendInput) {
        Robot robot = new Robot(frontendInput.getCurrentPossitionOfRobot(), frontendInput.getCurrentHeadingOfRobot());
        Grid grid = new Grid(5, 5, robot);
        if (!grid.isRobotPositionWithinGrid()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Robot current position is outside of the grid. Wrong input?");
        }

        try {
            grid.moveRobot(frontendInput.getControls());
        } catch (IllegalArgumentException iae) {
            logger.error("Error while moving robot on grid.", iae);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parameter wrong! Error message: " + iae.getMessage());
        } catch (OutOfGridException oofe) {
            logger.error("Error while moving robot. Robot moved outside of the grid.", oofe);
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Robot tried to move outside of the grid.");
        }

        return grid.getRobot();
    }
}
