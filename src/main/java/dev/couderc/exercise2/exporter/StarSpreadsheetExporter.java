package dev.couderc.exercise2.exporter;

import dev.couderc.exercise2.spreadsheet.core.Spreadsheet;

/**
 * Spreadsheet exporter in a star separated value text format
 * @author J Couderc
 */
public class StarSpreadsheetExporter extends AbstractSpreadsheetExporter {
    private static final char SEPARATOR = '*';

    public StarSpreadsheetExporter(Spreadsheet sheet) {
        super(sheet);
    }

    @Override
    protected char getSeparator() {
        return SEPARATOR;
    }
}
