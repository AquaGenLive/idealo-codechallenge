package de.idealo.robotcontrol.ui;

import de.idealo.robotcontrol.Control.ControlParser;
import de.idealo.robotcontrol.Control.PositionControl;
import de.idealo.robotcontrol.robot.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlParserTest {

    @Test
    void parseNonExistingControl() {
        final ControlFormElement element = new ControlFormElement(1, "TEST");

        assertThrows(RuntimeException.class, () -> {
            ControlParser.parseControl(element);
        });
    }

    @Test
    void parseControlsForPositionCommand() {
        ControlFormElement element = new ControlFormElement(1, "POSITION 1 3 EAST");

        PositionControl control = (PositionControl) ControlParser.parseControl(element);
        PositionControl expected = new PositionControl(1, 3, Robot.Heading.EAST);
        assertEquals(expected, control);
    }

    @Test
    void parseControlsForPositionCommandFailureWithNotEnoghtArguments() {
        final ControlFormElement element = new ControlFormElement(1, "POSITION 1 3");

        assertThrows(IllegalArgumentException.class, () -> {
            ControlParser.parseControl(element);
        });
    }

    @Test
    void parseControlsForPositionCommandFailureWithWrongArguments() {
        final ControlFormElement element = new ControlFormElement(1, "POSITION ONE 3 EAST");

        assertThrows(IllegalArgumentException.class, () -> {
            ControlParser.parseControl(element);
        });
    }
}