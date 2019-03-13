package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.robot.Robot;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @org.junit.jupiter.api.Test
    void isRobotPositionWithinGrid() {
        Robot testData = new Robot(1, 3, Robot.Heading.EAST);
        Grid grid = new Grid();
        assertTrue(grid.isRobotPositionWithinGrid(testData));
    }

    @org.junit.jupiter.api.Test
    void isRobotPositionOutsideTheGrid() {
        Robot testData = new Robot(1, 6, Robot.Heading.EAST);
        Grid grid = new Grid();
        assertFalse(grid.isRobotPositionWithinGrid(testData));
    }
}