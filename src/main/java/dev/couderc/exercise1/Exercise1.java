package dev.couderc.exercise1;

import java.util.*;

/**
 * @author J Couderc
 */
public final class Exercise1 {
    public static <T> List<T> getDuplicates(List<T> elements) {
        Set<T> seen = new LinkedHashSet<>();
        Set<T> duplicates = new HashSet<>();

        for (T e : elements) {
            if (seen.contains(e)) {
                duplicates.add(e);
            }
            seen.add(e);
        }

        return seen.stream().filter(duplicates::contains).toList();
    }
}