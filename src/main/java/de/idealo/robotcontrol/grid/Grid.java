package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.robot.Robot;

public class Grid {

    private static final int GRID_SIZE_X = 5;
    private static final int GRID_SIZE_Y = 5;


    public static boolean isRobotPositionWithinGrid(Robot robot) {
        return robot.getPositionX() <= GRID_SIZE_X && robot.getPositionY() <= GRID_SIZE_Y;
    }

    public static String gridSize() {
        return new StringBuilder("x = ")
                .append(GRID_SIZE_X)
                .append("; y = ")
                .append(GRID_SIZE_Y)
                .append(";")
                .toString();
    }
}
