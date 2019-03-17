package de.idealo.robotcontrol.control;

import de.idealo.robotcontrol.grid.Robot;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForwardControl implements Control {

    private int steps;


    @Override
    public void move(Robot robot) {
        switch (robot.getHeading()) {
            case EAST:
                robot.getPosition().addX(steps);
                break;
            case SOUTH:
                robot.getPosition().addY(steps);
                break;
            case WEST:
                robot.getPosition().addX(steps * -1);
                break;
            case NORTH:
                robot.getPosition().addY(steps * -1);
                break;
        }
    }
}
