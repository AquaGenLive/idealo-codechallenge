package de.idealo.robotcontrol.Control;

import de.idealo.robotcontrol.robot.Robot;
import de.idealo.robotcontrol.ui.ControlFormElement;

public class ControlParser {

    public static Control parseControl(ControlFormElement element) {
        if (element.getControl().startsWith("POSITION")) {
            return parsePositionControl(element.getControl());
        } else if (element.getControl().startsWith("FORWARD")) {
            return parseForwardControl(element.getControl());
        } else if (element.getControl().startsWith("WAIT")) {
            return new WaitControl();
        } else if (element.getControl().startsWith("TURNAROUND")) {
            return new TurnaroundControl();
        }

        throw new RuntimeException("Can't find a suitable control for: [" + element.getControl() + "]");
    }

    private static Control parseForwardControl(String control) {
        String[] elements = control.split(" ");
        if (elements.length != 2) {
            throw new IllegalArgumentException("FORWARD command needs the form [FORWARD steps] e.g. [FORWARD 1]");
        }
        int steps = Integer.parseInt(elements[1]);
        if (steps > 0 && steps <= 3) {
            return new ForwardControl(steps);
        }
        throw new IllegalArgumentException("Command: [" + control + "] is not matching the format: [FORWARD steps]");
    }


    private static Control parsePositionControl(String control) {
        String[] elements = control.split(" ");
        if (elements.length != 4) {
            throw new IllegalArgumentException("POSITION command needs the form [POSITION x y heading] e.g. [POSITION 1 3 EAST]");
        }
        int x = Integer.parseInt(elements[1]);
        int y = Integer.parseInt(elements[2]);
        Robot.Heading heading = Robot.Heading.valueOf(elements[3]);
        if (elements[0].equals("POSITION") &&
                x >= 0 &&
                y >= 0) {
            return new PositionControl(x, y, heading);
        }

        throw new IllegalArgumentException("Command: [" + control + "] is not matching the format: [POSITION x y heading]");
    }
}
