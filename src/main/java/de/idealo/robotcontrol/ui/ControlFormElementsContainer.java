package de.idealo.robotcontrol.ui;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ControlFormElementsContainer {
    private ControlFormElement controlFormElement1;
    private ControlFormElement controlFormElement2;
    private ControlFormElement controlFormElement3;
    private ControlFormElement controlFormElement4;
    private ControlFormElement controlFormElement5;
    private ControlFormElement controlFormElement6;
    private ControlFormElement controlFormElement7;
    private ControlFormElement controlFormElement8;
    private ControlFormElement controlFormElement9;
    private ControlFormElement controlFormElement10;

    public List<ControlFormElement> allControlFormElements() {
        return Arrays.asList(controlFormElement1,
                controlFormElement2,
                controlFormElement3,
                controlFormElement4,
                controlFormElement5,
                controlFormElement6,
                controlFormElement7,
                controlFormElement8,
                controlFormElement9,
                controlFormElement10
        );
    }
}
