package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class Oven implements Comparable<Oven>{
    private final ResourceStorage resourceStorage;
    private final String name;
    private boolean Broken = false;
    protected int amountOfOrbs = 0;

    /**
     * Create a resourceStorage.
     */
    public Oven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    /**
     * Create a resourceStorage.
     */
    public String getName() {
        return name;
    }

    /**
     * Create a resourceStorage.
     */
    public ResourceStorage getResourceStorage() {
        return resourceStorage;
    }

    /**
     * Create a resourceStorage.
     */
    public int getCreatedOrbsAmount() {
        return amountOfOrbs;
    }

    /**
     * Create a resourceStorage.
     */
    public boolean isBroken() {
        return this.Broken;
    }

    /**
     * Create a resourceStorage.
     */
    public void makeBroken() {
        this.Broken = true;
    }

    /**
     * Create a resourceStorage.
     */
    public boolean helpMethod(String resource) {
        if (!resourceStorage.returnMap().isEmpty()) {
            for (String existedResource : resourceStorage.returnMap().keySet()) {
                if (resource.equalsIgnoreCase(existedResource) && resourceStorage.returnMap().get(existedResource) >= 1) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Create a resourceStorage.
     */
    public Optional<Orb> craftOrb() {
        if (!isBroken() && !resourceStorage.isEmpty() && helpMethod("pearl") && helpMethod("silver")) {
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            amountOfOrbs += 1;
            if (amountOfOrbs == 15) {
               makeBroken();
            }
            Orb value = new Orb(this.name);
            value.charge("pearl", 1);
            value.charge("silver", 1);
            return Optional.of(value);
        }
        return Optional.empty();
    }

    /**
     * Create a resourceStorage.
     */
    public int compareTo(Oven o) {
        return 0;
    }

}