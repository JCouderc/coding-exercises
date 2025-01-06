package dev.couderc.exercise2.spreadsheet.core;

/**
 * @author J Couderc
 */
public interface Spreadsheet {

    String get(int row, int column);

    int getNumberOfRows();

    int getNumberOfColumns();
}
