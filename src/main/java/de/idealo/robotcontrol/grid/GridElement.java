package de.idealo.robotcontrol.grid;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GridElement {
    private int elementNumber;
    private boolean isRobotOnThisElement;
}
