package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.control.Control;
import de.idealo.robotcontrol.control.ControlParser;
import de.idealo.robotcontrol.ui.ControlFormElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

/**
 * Domain representation of a Grid where a {@code Robot} is moving around.
 */
@AllArgsConstructor
public class Grid {

    private int gridMaxSideX;
    private int gridMaxSizeY;
    @Getter
    private Robot robot;

    public static Grid defaultGrid(Robot robot) {
        return new Grid(5, 5, robot);
    }

    public boolean isRobotPositionWithinGrid() {
        return robot.getPosition().getX() <= gridMaxSideX &&
                robot.getPosition().getY() <= gridMaxSizeY &&
                robot.getPosition().getX() >= 0 &&
                robot.getPosition().getY() >= 0;
    }

    public Robot moveRobot(List<ControlFormElement> controlFormElements) {
        controlFormElements.sort(Comparator.comparingLong(ControlFormElement::getId));

        for (ControlFormElement controlElement : controlFormElements) {
            Control control = ControlParser.parseControl(controlElement);
            control.move(robot);
            if (!isRobotPositionWithinGrid()) {
                throw new OutOfGridException();
            }
        }
        return robot;
    }
}
