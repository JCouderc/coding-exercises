package dev.couderc.exercise3;

import java.util.Map;
import java.util.Set;

/**
 * @author J Couderc
 */
public class PackageDependencies {

    private static final int SPACES_BY_LEVEL = 2;

    private final Map<String, Set<String>> dependenciesMap;

    public PackageDependencies(Map<String, Set<String>> dependenciesMap) {
        this.dependenciesMap = dependenciesMap;
    }

    /**
     * Retrieves the direct dependencies of a package
     * @param packageName The package name
     * @return The dependencies package names.
     */
    public Set<String> getDependencies(String packageName) {
        return this.dependenciesMap.getOrDefault(packageName, Set.of());
    }

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
