package dev.couderc.exercise2;

import dev.couderc.exercise2.spreadsheet.SpreadsheetImpl;

/**
 * @author J Couderc
 */
public class Office {
    public static SpreadsheetImpl newSpreadsheet(int rows, int columns) {
        return new SpreadsheetImpl(rows, columns);
    }
}
