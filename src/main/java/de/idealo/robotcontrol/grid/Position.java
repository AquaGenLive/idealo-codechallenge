package de.idealo.robotcontrol.grid;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Position {
    private int x;
    private int y;

    public void addX(int addValue) {
        x = x + addValue;
    }

    public void addY(int addValue) {
        y = y + addValue;
    }
}
