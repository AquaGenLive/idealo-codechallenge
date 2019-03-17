package de.idealo.robotcontrol.control;

import de.idealo.robotcontrol.grid.Robot;
import lombok.Data;

@Data
public class EmptyControl implements Control {

    @Override
    public void move(Robot robot) {
        // do nothing
    }
}
