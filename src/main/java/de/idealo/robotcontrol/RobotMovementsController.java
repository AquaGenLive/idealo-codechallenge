package de.idealo.robotcontrol;

import de.idealo.robotcontrol.grid.Grid;
import de.idealo.robotcontrol.grid.OutOfGridException;
import de.idealo.robotcontrol.grid.Robot;
import de.idealo.robotcontrol.ui.MovementInstructions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RobotMovementsController {

    private static final  Logger LOGGER = LoggerFactory.getLogger(RobotMovementsController.class);

    @PostMapping("/robot-movements")
    public Robot robotMovements(@RequestBody MovementInstructions movementInstructions) {
        Robot robot = new Robot(movementInstructions);
        Grid grid = Grid.defaultGrid(robot);
        if (!grid.isRobotPositionWithinGrid()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Robot current position is outside of the grid. Wrong input?");
        }

        try {
            grid.moveRobot(movementInstructions.getControls());
        } catch (IllegalArgumentException iae) {
            LOGGER.error("Error while moving robot on grid.", iae);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parameter wrong! Error message: " + iae.getMessage());
        } catch (OutOfGridException oofe) {
            LOGGER.error("Error while moving robot. Robot moved outside of the grid.", oofe);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Robot tried to move outside of the grid.");
        }

        return grid.getRobot();
    }
}
