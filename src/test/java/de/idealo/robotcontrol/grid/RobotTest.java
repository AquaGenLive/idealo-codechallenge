package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.control.Control;
import de.idealo.robotcontrol.control.ForwardControl;
import de.idealo.robotcontrol.control.PositionControl;
import de.idealo.robotcontrol.control.RightControl;
import de.idealo.robotcontrol.control.TurnaroundControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RobotTest {

    @Test
    void moveWithPositionControl() {
        Control control = new PositionControl(2, 2, Robot.Heading.SOUTH);
        Robot robot = Robot.robotOnStartPosition();

        control.move(robot);
        assertTrue(robot.isOnPosition(new Position(2, 2)));
        assertEquals(Robot.Heading.SOUTH, robot.getHeading());
    }

    @Test
    void moveWithForwardControl() {
        Control control = new ForwardControl(2);
        Robot robot = Robot.robotOnStartPosition();

        control.move(robot);
        assertEquals(new Position(2, 0), robot.getPosition());

        robot.setHeading(Robot.Heading.SOUTH);
        control.move(robot);
        assertEquals(new Position(2, 2), robot.getPosition());

        robot.setHeading(Robot.Heading.NORTH);
        control.move(robot);
        assertEquals(new Position(2, 0), robot.getPosition());

        robot.setHeading(Robot.Heading.WEST);
        control.move(robot);
        assertEquals(new Position(0, 0), robot.getPosition());
    }

    @Test
    void turnaroundRobot() {
        final Control control = new TurnaroundControl();
        Robot robot = Robot.robotOnStartPosition();

        control.move(robot);
        assertEquals(Robot.Heading.WEST, robot.getHeading());

        control.move(robot);
        assertEquals(Robot.Heading.EAST, robot.getHeading());

        robot.setHeading(Robot.Heading.NORTH);
        control.move(robot);
        assertEquals(Robot.Heading.SOUTH, robot.getHeading());

        control.move(robot);
        assertEquals(Robot.Heading.NORTH, robot.getHeading());
    }

    @Test
    void moveHeadingRight() {
        final Control control = new RightControl();
        Robot robot = Robot.robotOnStartPosition();

        control.move(robot);
        assertEquals(Robot.Heading.SOUTH, robot.getHeading());

        control.move(robot);
        assertEquals(Robot.Heading.WEST, robot.getHeading());

        control.move(robot);
        assertEquals(Robot.Heading.NORTH, robot.getHeading());

        control.move(robot);
        assertEquals(Robot.Heading.EAST, robot.getHeading());
    }
}