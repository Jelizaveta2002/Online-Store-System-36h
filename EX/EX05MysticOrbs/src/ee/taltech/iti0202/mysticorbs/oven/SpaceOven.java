package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.orb.SpaceOrb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven {
    private int amountOfOrbs = 0;
    private boolean Broken = false;
    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    public boolean helpMethodSpaceOrb(String resource) {
        if (!super.getResourceStorage().returnMap().isEmpty()) {
            for (String existedResource : super.getResourceStorage().returnMap().keySet()) {
                if (resource.equalsIgnoreCase(existedResource) && super.getResourceStorage().returnMap().get(existedResource) >= 15 && resource.equalsIgnoreCase("star fragment")) {
                    return true;
                }
                if (resource.equalsIgnoreCase(existedResource) && super.getResourceStorage().returnMap().get(existedResource) >= 1 && resource.equalsIgnoreCase("meteorite stone")){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean helpMethodStandardOrb(String resource) {
        if (!super.getResourceStorage().returnMap().isEmpty()) {
            for (String existedResource : super.getResourceStorage().returnMap().keySet()) {
                if (resource.equalsIgnoreCase(existedResource) && super.getResourceStorage().returnMap().get(existedResource) >= 1 && resource.equalsIgnoreCase("pearl")) {
                    return true;
                }
                if (resource.equalsIgnoreCase(existedResource) && super.getResourceStorage().returnMap().get(existedResource) >= 1 && resource.equalsIgnoreCase("silver")){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Optional<Orb> craftOrb() {
        if (!Broken && !super.getResourceStorage().isEmpty() && helpMethodSpaceOrb("meteorite stone") && helpMethodSpaceOrb("star fragment")) {
            super.getResourceStorage().takeResource("star fragment", 15);
            super.getResourceStorage().takeResource("meteorite stone", 1);
            amountOfOrbs += 1;
            if (amountOfOrbs == 25) {
                Broken = true;
            }
            Orb value = new SpaceOrb(this.getName());
            return Optional.of(value);
        }
        if (Broken && !super.getResourceStorage().isEmpty() && helpMethodStandardOrb("pearl") && helpMethodStandardOrb("silver")
                && (!helpMethodSpaceOrb("meteorite stone") || !helpMethodSpaceOrb("star fragment"))) {
            super.getResourceStorage().takeResource("pearl", 1);
            super.getResourceStorage().takeResource("silver", 1);
            Orb value = new Orb(this.getName());
            value.charge("pearl", 1);
            value.charge("silver", 1);
            amountOfOrbs += 1;
            return Optional.of(value);
        }
        return Optional.empty();
    }

    public boolean isBroken() {
        return this.Broken;
    }
    public int getCreatedOrbsAmount() {
        return amountOfOrbs;
    }
}
