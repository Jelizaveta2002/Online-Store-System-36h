package ee.taltech.iti0202.mysticorbs.storage;

import java.util.HashMap;

public class ResourceStorage {

    /**
     * Create a resourceStorage.
     */
    private final HashMap<String, Integer> mapOfResources = new HashMap<String, Integer>();

    /**
     * Create a resourceStorage.
     */
    public boolean isEmpty() {
        if (!mapOfResources.isEmpty()) {
            for (String key : mapOfResources.keySet()) {
                if (mapOfResources.get(key) > 0) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    /**
     * Create a resourceStorage.
     */
    public void addResource(String resource, int amount) {
        if (!mapOfResources.isEmpty() && amount > 0 && !resource.trim().isEmpty()) {
            for (String existedResource : mapOfResources.keySet()) {
                if (resource.equalsIgnoreCase(existedResource)) {
                    mapOfResources.put(existedResource, mapOfResources.get(existedResource) + amount);
                    return;
                }
            }
            mapOfResources.put(resource, amount);
        } else if (mapOfResources.isEmpty() && amount > 0 && !resource.trim().isEmpty()) {
            mapOfResources.put(resource, amount);
        }
    }

    /**
     * Create a resourceStorage.
     */
    public int getResourceAmount(String resource) {
        if (!mapOfResources.isEmpty()) {
            for (String existedResource : mapOfResources.keySet()) {
                if (existedResource.equalsIgnoreCase(resource)) {
                    return mapOfResources.get(existedResource);
                }
            }
        }
        return 0;
    }

    /**
     * Create a resourceStorage.
     */
    public boolean hasEnoughResource(String resource, int amount) {
        if (!mapOfResources.isEmpty()) {
            for (String existedResource : mapOfResources.keySet()) {
                if (resource.equalsIgnoreCase(existedResource)) {
                    return amount >= 1 && amount <= this.getResourceAmount(resource);
                }
            }
        }
        return false;
    }

    /**
     * Create a resourceStorage.
     */
    public boolean takeResource(String resource, int amount) {
        if (!mapOfResources.isEmpty() && amount > 0 && !resource.trim().isEmpty()) {
            for (String existedResource : mapOfResources.keySet()) {
                if (resource.equalsIgnoreCase(existedResource) && mapOfResources.get(existedResource) >= amount) {
                    mapOfResources.put(existedResource, mapOfResources.get(existedResource) - amount);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Create a resourceStorage.
     */
    public HashMap<String, Integer> returnMap() {
        return this.mapOfResources;
    }

}
