package dev.couderc.exercise2.exporter;

import dev.couderc.exercise2.spreadsheet.core.Spreadsheet;

/**
 * Abstract spreadsheet exporter
 * @author J Couderc
 */
public abstract class AbstractSpreadsheetExporter {

    private final Spreadsheet sheet;

    public AbstractSpreadsheetExporter(Spreadsheet sheet) {
        this.sheet = sheet;
    }

    /**
     * Returns the implementation specific separator
     * @return The spreadsheet separator character.
     */
    abstract char getSeparator();

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
                sb.append(this.sheet.get(i, j)).append(getSeparator());
            }
        }
        return sb.toString();
    }
}
