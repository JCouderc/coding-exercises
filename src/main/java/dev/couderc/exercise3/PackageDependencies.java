package dev.couderc.exercise3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

/**
 * @author J Couderc
 */
public class PackageDependencies {

    private static final int SPACES_BY_LEVEL = 2;

    private final Map<String, Set<String>> dependenciesMap;

    public PackageDependencies(String jsonInput) {
        this.dependenciesMap = PackageDependenciesMapper.fromJson(jsonInput);
    }

    public PackageDependencies(Path jsonFile) {
        try {
            this.dependenciesMap = PackageDependenciesMapper.fromJson(Files.readString(jsonFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the direct dependencies of a package
     * @param packageName The package name
     * @return The dependencies package names.
     */
    public Set<String> getDependencies(String packageName) {
        return this.dependenciesMap.getOrDefault(packageName, Set.of());
    }

    /**
     * Returns a basic graph representation of each package dependencies
     * @return The graph representation.
     */
    public String buildBasicTreeRepresentation() {
        StringBuilder sb = new StringBuilder();
        this.dependenciesMap.keySet().forEach(key -> {
            appendWithLevel(sb, key, 0);
        });
        return sb.toString();
    }

    private void appendWithLevel(StringBuilder sb, String key, int level) {
        sb.append(" ".repeat(level * SPACES_BY_LEVEL))
                .append("- ")
                .append(key)
                .append("\n");
        for (String dependency : getDependencies(key)) {
            appendWithLevel(sb, dependency, level + 1);
        }
    }
}
