package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.Control.Control;
import de.idealo.robotcontrol.Control.ControlParser;
import de.idealo.robotcontrol.robot.Robot;
import de.idealo.robotcontrol.ui.ControlFormElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class Grid {

    private int gridMaxSideX;
    private int gridMaxSizeY;
    @Getter
    private Robot robot;

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
            robot.move(control);
            if (!isRobotPositionWithinGrid()) {
                throw new OutOfGridException();
            }
        }
        return robot;
    }
}
