package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

public class InfinityMagicOven {
    private final String name;
    private final ResourceStorage resourceStorage;
    public InfinityMagicOven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    public boolean isBroken() {
        return false;
    }
}
