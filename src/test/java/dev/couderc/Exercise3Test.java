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
        Assertions.assertEquals("""
                - pkg1
                  - pkg2
                    - pkg3
                  - pkg3
                - pkg2
                  - pkg3
                - pkg3
                """, new PackageDependencies(Path.of("src/test/resources/pkg-dependencies.json")).buildBasicTree());
    }

    @Test
    void getPrettyDependencyGraphRepresentationFromFile() {
        Assertions.assertEquals("""
                +--- pkg1
                |    +--- pkg2
                |    |    \\--- pkg3
                |    \\--- pkg3
                +--- pkg2
                |    \\--- pkg3
                \\--- pkg3
                """, new PackageDependencies(Path.of("src/test/resources/pkg-dependencies.json")).buildPrettyTree());
    }
}
