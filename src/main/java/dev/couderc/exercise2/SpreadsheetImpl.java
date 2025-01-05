package dev.couderc.exercise2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Basic implementation of a spreadsheet
 * @author J Couderc
 */
public class SpreadsheetImpl {

    private static final String DEFAULT_VALUE = "";

    private final ArrayList<ArrayList<String>> grid;

    /**
     * Constructs a new spreadsheet with the specified size
     * @param rows Number of rows in the spreadsheet
     * @param columns Number of columns in the spreadsheet
     */
    public SpreadsheetImpl(int rows, int columns) {
        this.grid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            this.grid.add(new ArrayList<>(Collections.nCopies(columns, DEFAULT_VALUE)));
        }
    }

    /**
     * Retrieves the content of a cell in the spreadsheet
     * @param row Cell row index
     * @param column Cell column index
     * @return the cell content at the specified position
     */
    public String get(int row, int column) {
        return this.grid.get(row).get(column);
    }

    /**
     * Updates the content of a cell at the specified position
     * @param row Cell row index
     * @param column Cell column index
     * @param value The new cell value
     */
    public void put(int row, int column, String value) {
        this.grid.get(row).set(column, value);
    }

    public ValueType getValueType(int i, int i1) {
        return null;
    }
}
