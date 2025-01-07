package dev.couderc;


import dev.couderc.exercise3.PackageDependencies;
import dev.couderc.exercise3.PackageDependenciesMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Exercise3Test {

    @Test
    void getPackageDependencies() {
        PackageDependencies graph = PackageDependenciesMapper.fromJson("""
                {
                  "pkg1": ["pkg2", "pkg3"],
                  "pkg2": ["pkg3"],
                  "pkg3": []
                }
                """);

        Assertions.assertIterableEquals(List.of("pkg2", "pkg3"), graph.getDependencies("pkg1"));
        Assertions.assertIterableEquals(List.of("pkg3"), graph.getDependencies("pkg2"));
        Assertions.assertTrue(graph.getDependencies("pkg3").isEmpty());
    }
}
