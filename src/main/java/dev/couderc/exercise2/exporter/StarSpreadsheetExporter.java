package dev.couderc.exercise2.exporter;

import dev.couderc.exercise2.spreadsheet.core.Spreadsheet;
import dev.couderc.exercise2.spreadsheet.impl.SpreadsheetImpl;

/**
 * Spreadsheet exporter in a star separated value text format
 * @author J Couderc
 */
public class StarSpreadsheetExporter {
    private static final char SEPARATOR = '*';

    private final Spreadsheet sheet;

    public StarSpreadsheetExporter(Spreadsheet sheet) {
        this.sheet = sheet;
    }

    /**
     * Exports the spreadsheet in a star separated value text format
     * @return The exported spreadsheet
     */
    public String export() {
        StringBuilder sb = new StringBuilder();
        int rows = this.sheet.getNumberOfRows();
        int columns = this.sheet.getNumberOfColumns();
        sb.append(rows).append(',').append(columns).append('#');
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sb.append(this.sheet.get(i, j)).append(SEPARATOR);
            }
        }
        return sb.toString();
    }
}
