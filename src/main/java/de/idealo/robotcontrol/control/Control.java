package de.idealo.robotcontrol.control;

import de.idealo.robotcontrol.grid.Robot;

/**
 * Interface to run {@code Robot} commands / movements.
 */
public interface Control {

    void move(Robot robot);
}
