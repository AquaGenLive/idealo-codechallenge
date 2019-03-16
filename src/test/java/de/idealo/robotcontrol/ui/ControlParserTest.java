package de.idealo.robotcontrol.ui;

import de.idealo.robotcontrol.Control.ControlParser;
import de.idealo.robotcontrol.Control.ForwardControl;
import de.idealo.robotcontrol.Control.PositionControl;
import de.idealo.robotcontrol.Control.RightControl;
import de.idealo.robotcontrol.Control.TurnaroundControl;
import de.idealo.robotcontrol.Control.WaitControl;
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
        final ControlFormElement element = new ControlFormElement(1, "POSITION 1 3 EAST");

        PositionControl control = (PositionControl) ControlParser.parseControl(element);
        PositionControl expected = new PositionControl(1, 3, Robot.Heading.EAST);
        assertEquals(expected, control);
    }

    @Test
    void parseControlsForPositionCommandFailureWithNotEnoghtArguments() {
        final ControlFormElement element = new ControlFormElement(1, "POSITION 1 3");
        validateIllegalArguementException(element);
    }

    @Test
    void parseControlsForPositionCommandFailureWithWrongArguments() {
        final ControlFormElement element = new ControlFormElement(1, "POSITION ONE 3 EAST");
        validateIllegalArguementException(element);
    }

    private void validateIllegalArguementException(ControlFormElement element) {
        assertThrows(IllegalArgumentException.class, () -> {
            ControlParser.parseControl(element);
        });
    }

    @Test
    void parseControlsForForwardCommand() {
        final ControlFormElement element = new ControlFormElement(1, "FORWARD 2");

        ForwardControl control = (ForwardControl) ControlParser.parseControl(element);
        ForwardControl expected = new ForwardControl(2);
        assertEquals(expected, control);
    }

    @Test
    void parseControlsForForwardCommandFailureWithWrongFormat() {
        final ControlFormElement element = new ControlFormElement(1, "FORWARD TWO");
        validateIllegalArguementException(element);
    }

    @Test
    void parseControlsForForwardCommandFailureWithOutOfRange() {
        final ControlFormElement element = new ControlFormElement(1, "FORWARD 4");
        validateIllegalArguementException(element);
    }

    @Test
    void parseControlsForForwardCommandFailureWithoutStep() {
        final ControlFormElement element = new ControlFormElement(1, "FORWARD");
        validateIllegalArguementException(element);
    }

    @Test
    void parseControlsForWaitCommand() {
        final ControlFormElement element = new ControlFormElement(1, "WAIT");

        WaitControl control = (WaitControl) ControlParser.parseControl(element);
        WaitControl expected = new WaitControl();
        assertEquals(expected, control);
    }

    @Test
    void parseControlsForTurnaroundCommand() {
        final ControlFormElement element = new ControlFormElement(1, "TURNAROUND");

        TurnaroundControl control = (TurnaroundControl) ControlParser.parseControl(element);
        TurnaroundControl expected = new TurnaroundControl();
        assertEquals(expected, control);
    }

    @Test
    void parseControlsForRightCommand() {
        final ControlFormElement element = new ControlFormElement(1, "RIGHT");

        RightControl control = (RightControl) ControlParser.parseControl(element);
        RightControl expected = new RightControl();
        assertEquals(expected, control);
    }
}