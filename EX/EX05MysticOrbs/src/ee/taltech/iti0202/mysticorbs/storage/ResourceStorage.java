package ee.taltech.iti0202.mysticorbs.storage;

import java.util.HashMap;

public class ResourceStorage {
    private final HashMap<String, Integer> mapOfResources = new HashMap<String, Integer>();

    public boolean isEmpty() {
        if (! mapOfResources.isEmpty()) {
            for (String key : mapOfResources.keySet()) {
                if (mapOfResources.get(key) > 0) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public void addResource(String resource, int amount) {
        if (!mapOfResources.isEmpty() && amount > 0) {
            for (String existedResource : mapOfResources.keySet()) {
                if (resource.equalsIgnoreCase(existedResource)) {
                    mapOfResources.put(existedResource, mapOfResources.get(existedResource) + amount);
                    return;
                }
            }
            mapOfResources.put(resource, amount);
        } else if (mapOfResources.isEmpty() && amount > 0) {
            mapOfResources.put(resource, amount);
        }
    }

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

    public boolean takeResource(String resource, int amount) {
        if (!mapOfResources.isEmpty()) {
            for (String existedResource : mapOfResources.keySet()) {
                if (resource.equalsIgnoreCase(existedResource) && mapOfResources.get(existedResource) >= amount) {
                    mapOfResources.replace(existedResource, mapOfResources.get(existedResource) - amount);
                    return mapOfResources.get(resource) >= amount;
                }
            }
        }
        return false;
    }

    public HashMap<String, Integer> returnMap() {
        return this.mapOfResources;
    }

    public static void main(String[] args) {
        ResourceStorage resourceStorage = new ResourceStorage();
        resourceStorage.addResource("wood", 33);
        resourceStorage.addResource("wood", 34);
        resourceStorage.addResource("water", 444);
        resourceStorage.takeResource("water", 1);
        System.out.println(resourceStorage.getResourceAmount("water"));
    }
}
