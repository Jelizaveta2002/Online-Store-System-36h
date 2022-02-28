package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.Optional;

public class Oven implements Comparable<Oven>{
    private final ResourceStorage resourceStorage;
    private final String name;
    private boolean Broken = false;
    private int amountOfOrbs = 0;

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
        if (amountOfOrbs >= 15) {
            this.Broken = true;
        }
        return amountOfOrbs;
    }

    public boolean isBroken() {
        return this.Broken;
    }

    public void makeBroken() {
        this.Broken = true;
    }

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

    public Optional<Orb> craftOrb() {
        if (!Broken && !resourceStorage.isEmpty() && helpMethod("pearl") && helpMethod("silver")) {
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            amountOfOrbs += 1;
            Orb value = new Orb(this.name);
            value.charge("pearl", 1);
            value.charge("silver", 1);
            return Optional.of(value);
        }
        return Optional.empty();
    }

    public int compareTo(Oven o) {
        return 0;
//        if (o == this ) {
//            return 0;
//        }
//        if
//
//        return 0;
    }

    public static void main(String[] args) {
        ResourceStorage resourceStorage = new ResourceStorage();
        resourceStorage.addResource("pearl", 10);
        resourceStorage.addResource("silver", 12);

        Oven oven = new Oven("oven", resourceStorage);

        Optional<Orb> optionalOrb = oven.craftOrb();
        Orb orb = optionalOrb.get();
        System.out.println(orb.getEnergy());
    }
}