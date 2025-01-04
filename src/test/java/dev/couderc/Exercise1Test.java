package dev.couderc;

import dev.couderc.exercise1.Exercise1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Exercise1Test {

    @Test
    void test() {
        Assertions.assertIterableEquals(List.of("a"), Exercise1.getDuplicates(List.of("a", "a")));
        Assertions.assertIterableEquals(
                List.of("a", "c", "d"),
                Exercise1.getDuplicates(List.of("b", "a", "c", "c", "e", "a", "c", "d", "c", "d"))
        );
        Assertions.assertIterableEquals(
                List.of('a', 'c', 'd'),
                Exercise1.getDuplicates(List.of('b', 'a', 'c', 'c', 'e', 'a', 'c', 'd', 'c', 'd'))
        );
    }
}
