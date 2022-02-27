package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

public class SpaceOven {
    private final String name;
    private final ResourceStorage resourceStorage;
    public SpaceOven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    public boolean craftOrb() {
        return false;
    }
}
