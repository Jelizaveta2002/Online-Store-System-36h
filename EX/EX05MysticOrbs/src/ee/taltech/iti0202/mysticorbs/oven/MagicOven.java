package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

public class MagicOven {

    private final String name;
    private final ResourceStorage resourceStorage;

    public MagicOven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    public boolean isBroken() {
        return false;
    }

    public boolean craftOrb() {
        return false;
    }
}
