package dev.couderc.exercise2.spreadsheet.impl;

import dev.couderc.exercise2.spreadsheet.core.ValueType;

/**
 * Spreadsheet cell data
 * @param type Type of cell
 * @param value Content of the cell
 * @author J Couderc
 */
public record Cell(ValueType type, String value) {
}
