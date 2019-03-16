package de.idealo.robotcontrol.control;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForwardControl implements Control {

    private int steps;
}
