package dev.couderc.exercise3;

import java.util.Map;
import java.util.Set;

/**
 * @author J Couderc
 */
public class PackageDependencies {

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
}
