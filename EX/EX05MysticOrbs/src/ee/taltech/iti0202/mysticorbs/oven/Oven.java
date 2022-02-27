package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class Oven {
    private final ResourceStorage resourceStorage;
    private final String name;
    private boolean Broken = false;

    public Oven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    public String getName() {
        return name;
    }

    public ResourceStorage getResourceStorage() {
        return resourceStorage;
    }

    public int getCreatedOrbsAmount() {
        int amountOfOrbs = this.resourceStorage.returnMap().size();
        if (amountOfOrbs >= 15) {
            this.Broken = true;
        }
        return amountOfOrbs;
    }

    public boolean isBroken() {
        return this.Broken;
    }

    public Optional<Orb> craftOrb() {
        return Optional.empty();
    }
}
