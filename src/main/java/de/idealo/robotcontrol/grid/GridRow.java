package de.idealo.robotcontrol.grid;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class GridRow {
    private int rowNumber;
    private List<GridElement> gridElements;

    public GridRow(int rowNumber) {
        this.rowNumber = rowNumber;
        this.gridElements = new ArrayList<>();
    }

    public void addElement(GridElement element) {
        gridElements.add(element);
    }
}
