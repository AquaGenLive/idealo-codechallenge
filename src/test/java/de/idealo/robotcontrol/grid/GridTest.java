package de.idealo.robotcontrol.grid;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GridTest {

    private Grid gridToTest;

    @org.junit.jupiter.api.Test
    void isRobotPositionWithinGrid() {
        Position testPosition = new Position(1, 3);
        Robot testData = new Robot(testPosition, Robot.Heading.EAST);
        gridToTest = new Grid(5, 5, testData);
        assertTrue(gridToTest.isRobotPositionWithinGrid());
    }

    @org.junit.jupiter.api.Test
    void isRobotPositionOutsideTheGrid() {
        Position testPosition = new Position(1, 6);
        Robot testData = new Robot(testPosition, Robot.Heading.EAST);
        gridToTest = new Grid(5, 5, testData);
        assertFalse(gridToTest.isRobotPositionWithinGrid());
    }
}