package ee.taltech.iti0202.mysticorbs.storage;

import java.util.HashMap;

public class ResourceStorage {
    private HashMap<String, Integer> mapOfResources = new HashMap<String, Integer>();

    public ResourceStorage() {
        mapOfResources = new HashMap<String, Integer>();
    }
    public boolean isEmpty() {
        if (! mapOfResources.isEmpty()) {
            for (String key : mapOfResources.keySet()) {
                if (mapOfResources.get(key) > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addResource(String resource, int amount) {
        if (!mapOfResources.isEmpty() && resource != null) {
            if(mapOfResources.containsKey(resource)) {
                mapOfResources.put(resource, mapOfResources.get(resource) + amount);
            } else {
                mapOfResources.put(resource, amount);
            }
        } else if (mapOfResources.isEmpty() && resource != null){
            mapOfResources.put(resource, amount);
        }
    }

    public int getResourceAmount(String resource) {
        if (mapOfResources.containsKey(resource)) {
            return mapOfResources.get(resource);
        }
        return 0;
    }

    public boolean hasEnoughResource(String resource, int amount) {
        if (mapOfResources.containsKey(resource)) {
            if (amount < 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean takeResource(String resource, int amount) {
        if (!mapOfResources.isEmpty()) {
            if (mapOfResources.containsKey(resource)) {
                return mapOfResources.get(resource) >= amount;
            }
            return false;
        }
        return false;
    }

    public HashMap<String, Integer> returnMap() {
        return this.mapOfResources;
    }
}
