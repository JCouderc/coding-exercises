package dev.couderc.exercise3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author J Couderc
 */
public class PackageDependenciesMapper {

    /**
     * Naive json parser that extracts key value pairs from an object
     * where keys are string and values are a list of strings
     * @param input The json input
     * @return The extracted map.
     */
    public static Map<String, Set<String>> fromJson(String input) {
        // Remove whitespaces, newlines and quotes
        input = input.replaceAll("[\\s\"]+", "");

        // Remove the object braces
        input = input.charAt(0) == '{' ? input.substring(1) : input;
        input = input.charAt(input.length() - 1) == '}' ? input.substring(0, input.length() - 1) : input;

        // Match each key-values pair
        Matcher keyValsMatcher = Pattern.compile("(?<key>[a-zA-Z0-9]+):\\[(?<vals>[a-zA-Z0-9,]+)?]").matcher(input);
        Map<String, Set<String>> result = new LinkedHashMap<>();
        while (keyValsMatcher.find()) {
            // Extract values
            String key = keyValsMatcher.group("key");
            String values = keyValsMatcher.group("vals");
            if (values == null) {
                result.put(key, Set.of());
            } else {
                List<String> valueList = Arrays.asList(values.split(","));
                result.put(key, new LinkedHashSet<>(valueList));
            }
        }
        return result;
    }

}
