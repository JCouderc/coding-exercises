package dev.couderc.exercise2.spreadsheet;

/**
 * Spreadsheet cell data
 * @param type Type of cell
 * @param value Content of the cell
 * @author J Couderc
 */
public record Cell(ValueType type, String value) {
}
