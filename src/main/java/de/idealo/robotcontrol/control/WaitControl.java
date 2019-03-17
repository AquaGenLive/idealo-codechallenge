package de.idealo.robotcontrol.control;

import de.idealo.robotcontrol.grid.Robot;
import lombok.Data;

@Data
public class WaitControl implements Control {
    @Override
    public void move(Robot robot) {
        // do nothing
    }
}
