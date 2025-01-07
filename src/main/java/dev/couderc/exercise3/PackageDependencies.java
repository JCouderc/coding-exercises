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
    private static final int PRETTY_SPACES_BY_LEVEL = 4;

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
    public String buildBasicTree() {
        StringBuilder sb = new StringBuilder();
        this.dependenciesMap.keySet().forEach(key -> {
            appendWithLevel(sb, key, 0);
        });
        return sb.toString();
    }

    public static String buildBasicTree(String filename) {
        return new PackageDependencies(Path.of(filename)).buildBasicTree();
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

    /**
     * Returns a 'pretty' graph representation of each package dependencies
     * @return The graph representation.
     */
    public String buildPrettyTree() {
        StringBuilder sb = new StringBuilder();
        Set<String> keys = this.dependenciesMap.keySet();
        int count = 0;
        for (String key : keys) {
            count++;
            prettyAppendWithLevel(sb, "", key, count == keys.size());
        }
        return sb.toString();
    }

    private void prettyAppendWithLevel(StringBuilder sb, String prefix, String key, boolean last) {
        sb.append(prefix)
                .append(last ? "\\--- " : "+--- ")
                .append(key)
                .append("\n");
        Set<String> dependencies = getDependencies(key);
        int count = 0;
        for (String dependency : dependencies) {
            count++;
            prettyAppendWithLevel(sb, prefix + "|" + " ".repeat(PRETTY_SPACES_BY_LEVEL), dependency, count == dependencies.size());
        }
    }

    public static String buildPrettyTree(String filename) {
        return new PackageDependencies(Path.of(filename)).buildPrettyTree();
    }
}
