package dev.couderc.exercise2.exporter;

import dev.couderc.exercise2.spreadsheet.core.Spreadsheet;

import java.util.stream.Stream;

/**
 * Spreadsheet exporter in a dash separated value text format
 * @author J Couderc
 */
public class DashSpreadsheetExporter extends AbstractSpreadsheetExporter {

    private static final char SEPARATOR = '-';

    public DashSpreadsheetExporter(Spreadsheet sheet) {
        super(sheet);
    }

    @Override
    protected char getSeparator() {
        return SEPARATOR;
    }
}
