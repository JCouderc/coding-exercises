package dev.couderc;

import dev.couderc.exercise1.Exercise1;
import dev.couderc.exercise2.Office;
import dev.couderc.exercise2.exporter.DashSpreadsheetExporter;
import dev.couderc.exercise2.exporter.StarSpreadsheetExporter;
import dev.couderc.exercise2.spreadsheet.core.Spreadsheet;
import dev.couderc.exercise2.spreadsheet.impl.SpreadsheetImpl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author J Couderc
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise 1");
        System.out.println(String.join(",", Exercise1.getDuplicates(List.of("b", "a", "c", "c", "e", "a", "c", "d", "c", "d"))));

        System.out.println("\nExercise 2");
        SpreadsheetImpl sheet = Office.newSpreadsheet(10, 5);
        sheet.put(0, 0, "a");
        sheet.put(1, 1, "b");
        sheet.put(2, 2, "c");
        sheet.put(3, 3, "d");
        sheet.put(3, 4, "e");
        System.out.println(new DashSpreadsheetExporter(sheet).export());
        System.out.println(new StarSpreadsheetExporter(sheet).export());
    }
}