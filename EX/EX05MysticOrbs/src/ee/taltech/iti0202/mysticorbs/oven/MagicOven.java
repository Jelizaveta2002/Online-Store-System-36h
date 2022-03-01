package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class MagicOven extends Oven {

    /**
     * Create a resourceStorage.
     */
    public MagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    /**
     * Create a resourceStorage.
     */
    public int getCreatedOrbsAmount() {
        return 0;
    }

    /**
     * Create a resourceStorage.
     */
    public boolean helpMethod(String resource) {
        if (!getResourceStorage().returnMap().isEmpty()) {
            for (String existedResource : getResourceStorage().returnMap().keySet()) {
                if (resource.equalsIgnoreCase(existedResource) && getResourceStorage().returnMap().get(existedResource) >= 3 && resource.equalsIgnoreCase("dust")) {
                    return true;
                }
                if (resource.equalsIgnoreCase(existedResource) && getResourceStorage().returnMap().get(existedResource) >= 1 && resource.equalsIgnoreCase("gold")){
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
    public int getCreatedAmount() {
        if (amountOfOrbs >= 5) {
            makeBroken();
        }
        return amountOfOrbs;
    }

    /**
     * Create a resourceStorage.
     */
    public Optional<Orb> craftOrb() {
        if (!isBroken() && !getResourceStorage().isEmpty() && helpMethod("gold") && helpMethod("dust")) {
            super.getResourceStorage().takeResource("gold", 1);
            super.getResourceStorage().takeResource("dust", 3);
            amountOfOrbs += 1;
            if (amountOfOrbs == 5) {
                makeBroken();
            }
            if (amountOfOrbs % 2 == 0) {
                Orb value = new MagicOrb(this.getName());
                value.charge("gold", 1);
                value.charge("dust", 3);
                return Optional.of(value);
            }
            Orb value = new Orb(this.getName());
            value.charge("gold", 1);
            value.charge("dust", 3);
            return Optional.of(value);
        }
        return Optional.empty();
    }

}