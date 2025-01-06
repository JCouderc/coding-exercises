package dev.couderc.exercise2.exporter;

import dev.couderc.exercise2.spreadsheet.core.Spreadsheet;

import java.util.stream.Stream;

/**
 * @author J Couderc
 */
public class DashSpreadsheetExporter {

    private static final char SEPARATOR = '-';

    private final Spreadsheet sheet;

    public DashSpreadsheetExporter(Spreadsheet sheet) {
        this.sheet = sheet;
    }

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
