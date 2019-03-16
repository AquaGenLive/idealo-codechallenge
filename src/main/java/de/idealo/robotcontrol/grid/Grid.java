package de.idealo.robotcontrol.grid;

import de.idealo.robotcontrol.robot.Robot;
import de.idealo.robotcontrol.ui.ControlFormElement;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

@AllArgsConstructor
public class Grid {

    private int gridMaxSideX;
    private int gridMaxSizeY;
    private Robot robot;
    private List<GridRow> gridRows;

    public Grid(int gridMaxSideX, int gridMaxSizeY, Robot robot) {
        this.gridMaxSideX = gridMaxSideX;
        this.gridMaxSizeY = gridMaxSizeY;
        this.robot = robot;
        initGridRows();
    }

    private void initGridRows() {
        this.gridRows = new ArrayList<>();
        for (int y = 0; y < gridMaxSizeY; y++) {
            GridRow row = new GridRow(y);
            for (int x = 0; x < gridMaxSideX; x++) {
                row.addElement(new GridElement(x, robot.isRobotOnPosition(new Position(x, y))));
            }
            gridRows.add(row);
        }
    }

    public boolean isRobotPositionWithinGrid() {
        return robot.getPosition().getX() <= gridMaxSideX && robot.getPosition().getY() <= gridMaxSizeY;
    }

    public Robot moveRobot(List<ControlFormElement> controlFormElements) {
        controlFormElements.sort(Comparator.comparingLong(ControlFormElement::getId));

        for (ControlFormElement control : controlFormElements) {
            if (control.getControl().startsWith("POSITION")) {
                StringTokenizer tokenizer = new StringTokenizer(control.getControl(), " ");
                if (tokenizer.countTokens() != 4) {
                    throw new IllegalArgumentException("POSITION command needs the form 'POSITION x y HEADING' e.g. 'POSITION 1 3 EAST'");
                }
            }
        }
        return robot;
    }

    public static Position getStartPosition() {
        return new Position(0, 0);
    }

    public String gridSize() {
        return new StringBuilder("x = ")
                .append(gridMaxSideX)
                .append("; y = ")
                .append(gridMaxSizeY)
                .append(";")
                .toString();
    }
}
