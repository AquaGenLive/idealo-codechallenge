package de.idealo.robotcontrol.robot;

import de.idealo.robotcontrol.Control.Control;
import de.idealo.robotcontrol.Control.ForwardControl;
import de.idealo.robotcontrol.Control.PositionControl;
import de.idealo.robotcontrol.Control.TurnaroundControl;
import de.idealo.robotcontrol.Control.WaitControl;
import de.idealo.robotcontrol.grid.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


@Data
@AllArgsConstructor
public class Robot {
    public enum Heading {
        NORTH,
        EAST,
        SOUTH,
        WEST;
    }

    private Position position;
    private Heading heading;

    public static Robot robotOnStartPosition() {
        return new Robot(new Position(0, 0), Heading.EAST);
    }


    public boolean isRobotOnPosition(Position position) {
        return this.position.equals(position);
    }

    public void move(Control control) {
        if (control instanceof PositionControl) {
            movePosition((PositionControl) control);
        } else if (control instanceof ForwardControl) {
            moveForward((ForwardControl) control);
        } else if (control instanceof WaitControl) {
            System.out.println("Robot is waiting...");
        } else if (control instanceof TurnaroundControl) {
            turnaround();
        } else {
            throw new NotImplementedException();
        }
    }

    private void turnaround() {
        switch (heading) {
            case NORTH:
                heading = Heading.SOUTH;
                break;
            case EAST:
                heading = Heading.WEST;
                break;
            case SOUTH:
                heading = Heading.NORTH;
                break;
            case WEST:
                heading = Heading.EAST;
                break;
        }
    }

    private void moveForward(ForwardControl control) {
        switch (heading) {
            case EAST:
                position.addX(control.getSteps());
                break;
            case SOUTH:
                position.addY(control.getSteps());
                break;
            case WEST:
                position.addX(control.getSteps() * -1);
                break;
            case NORTH:
                position.addY(control.getSteps() * -1);
                break;
        }
    }

    private void movePosition(PositionControl control) {
        position = new Position(control.getX(), control.getY());
        heading = control.getHeading();
    }

}
