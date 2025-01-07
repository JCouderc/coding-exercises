package dev.couderc;


import dev.couderc.exercise3.PackageDependencies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

public class Exercise3Test {

    @Test
    void getPackageDependencies() {
        PackageDependencies deps = new PackageDependencies("""
                {
                  "pkg1": ["pkg2", "pkg3"],
                  "pkg2": ["pkg3"],
                  "pkg3": []
                }
                """);

        Assertions.assertIterableEquals(List.of("pkg2", "pkg3"), deps.getDependencies("pkg1"));
        Assertions.assertIterableEquals(List.of("pkg3"), deps.getDependencies("pkg2"));
        Assertions.assertTrue(deps.getDependencies("pkg3").isEmpty());
    }

    @Test
    void getBasicDependencyGraphRepresentation() {
        PackageDependencies deps = new PackageDependencies("""
                {
                  "pkg1": ["pkg2", "pkg3"],
                  "pkg2": ["pkg3"],
                  "pkg3": []
                }
                """);
        Assertions.assertEquals("""
                - pkg1
                  - pkg2
                    - pkg3
                  - pkg3
                - pkg2
                  - pkg3
                - pkg3
                """, deps.buildBasicTree());
    }

    @Test
    void getBasicDependencyGraphRepresentationFromFile() {
        String expected = """
                - pkg1
                  - pkg2
                    - pkg3
                  - pkg3
                - pkg2
                  - pkg3
                - pkg3
                """;
        Assertions.assertEquals(expected, new PackageDependencies(Path.of("src/test/resources/pkg-dependencies.json")).buildBasicTree());
        Assertions.assertEquals(expected, PackageDependencies.buildBasicTree("src/test/resources/pkg-dependencies.json"));
    }

    @Test
    void getPrettyDependencyGraphRepresentationFromFile() {
        String expected = """
                +--- pkg1
                |    +--- pkg2
                |    |    \\--- pkg3
                |    \\--- pkg3
                +--- pkg2
                |    \\--- pkg3
                \\--- pkg3
                """;
        Assertions.assertEquals(expected, new PackageDependencies(Path.of("src/test/resources/pkg-dependencies.json")).buildPrettyTree());
        Assertions.assertEquals(expected, PackageDependencies.buildPrettyTree("src/test/resources/pkg-dependencies.json"));
    }
}
