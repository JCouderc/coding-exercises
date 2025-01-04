package dev.couderc;

import dev.couderc.exercise1.Exercise1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author J Couderc
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Exercise 1");
        System.out.println(String.join(",", Exercise1.getDuplicates(List.of("b", "a", "c", "c", "e", "a", "c", "d", "c", "d"))));

    }
}