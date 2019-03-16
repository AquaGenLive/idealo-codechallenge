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
import java.util.StringTokenizer;

@AllArgsConstructor
public class Grid {

    private int gridMaxSideX;
    private int gridMaxSizeY;
    @Getter
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
