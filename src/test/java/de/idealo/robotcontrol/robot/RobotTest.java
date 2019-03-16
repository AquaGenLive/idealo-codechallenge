package de.idealo.robotcontrol.robot;

import de.idealo.robotcontrol.Control.Control;
import de.idealo.robotcontrol.Control.ForwardControl;
import de.idealo.robotcontrol.Control.PositionControl;
import de.idealo.robotcontrol.Control.RightControl;
import de.idealo.robotcontrol.Control.TurnaroundControl;
import de.idealo.robotcontrol.grid.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void moveWithPositionControl() {
        Control control = new PositionControl(2, 2, Robot.Heading.SOUTH);
        Robot robot = Robot.robotOnStartPosition();

        robot.move(control);
        assertTrue(robot.isRobotOnPosition(new Position(2, 2)));
        assertEquals(Robot.Heading.SOUTH, robot.getHeading());
    }

    @Test
    void moveWithForwardControl() {
        Control control = new ForwardControl(2);
        Robot robot = Robot.robotOnStartPosition();

        robot.move(control);
        assertEquals(new Position(2, 0), robot.getPosition());

        robot.setHeading(Robot.Heading.SOUTH);
        robot.move(control);
        assertEquals(new Position(2, 2), robot.getPosition());

        robot.setHeading(Robot.Heading.NORTH);
        robot.move(control);
        assertEquals(new Position(2, 0), robot.getPosition());

        robot.setHeading(Robot.Heading.WEST);
        robot.move(control);
        assertEquals(new Position(0, 0), robot.getPosition());
    }

    @Test
    void turnaroundRobot() {
        final Control control = new TurnaroundControl();
        Robot robot = Robot.robotOnStartPosition();

        robot.move(control);
        assertEquals(Robot.Heading.WEST, robot.getHeading());

        robot.move(control);
        assertEquals(Robot.Heading.EAST, robot.getHeading());

        robot.setHeading(Robot.Heading.NORTH);
        robot.move(control);
        assertEquals(Robot.Heading.SOUTH, robot.getHeading());

        robot.move(control);
        assertEquals(Robot.Heading.NORTH, robot.getHeading());
    }

    @Test
    void moveHeadingRight() {
        final Control control = new RightControl();
        Robot robot = Robot.robotOnStartPosition();

        robot.move(control);
        assertEquals(Robot.Heading.SOUTH, robot.getHeading());

        robot.move(control);
        assertEquals(Robot.Heading.WEST, robot.getHeading());

        robot.move(control);
        assertEquals(Robot.Heading.NORTH, robot.getHeading());

        robot.move(control);
        assertEquals(Robot.Heading.EAST, robot.getHeading());
    }
}