package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.control.Control;
import de.idealo.robotcontrol.control.EmptyControl;
import de.idealo.robotcontrol.control.ForwardControl;
import de.idealo.robotcontrol.control.PositionControl;
import de.idealo.robotcontrol.control.RightControl;
import de.idealo.robotcontrol.control.TurnaroundControl;
import de.idealo.robotcontrol.control.WaitControl;
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

    /**
     * @return start position is x=0; y=0; heading=EAST.
     */
    public static Robot robotOnStartPosition() {
        return new Robot(new Position(0, 0), Heading.EAST);
    }


    public boolean isOnPosition(Position position) {
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
        } else if (control instanceof RightControl) {
            moveHeadingRight();
        } else if (control instanceof EmptyControl) {
            System.out.println("Empty control.");
        } else {
            throw new NotImplementedException();
        }
    }

    private void moveHeadingRight() {
        switch (heading) {
            case NORTH:
                heading = Heading.EAST;
                break;
            case EAST:
                heading = Heading.SOUTH;
                break;
            case SOUTH:
                heading = Heading.WEST;
                break;
            case WEST:
                heading = Heading.NORTH;
                break;
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
