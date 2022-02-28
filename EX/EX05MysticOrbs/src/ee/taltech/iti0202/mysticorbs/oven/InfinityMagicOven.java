package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.MagicOrb;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class InfinityMagicOven extends MagicOven {

    public InfinityMagicOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

//    public Optional<Orb> craftOrb() {
//        if (!super.getResourceStorage().isEmpty() && helpMethod("gold") && helpMethod("dust")) {
//            super.getResourceStorage().takeResource("gold", 1);
//            super.getResourceStorage().takeResource("dust", 3);
//            amountOfOrbs += 1;
//            if (amountOfOrbs == 2 || amountOfOrbs == 4) {
//                Orb value = new MagicOrb(this.getName());
//                value.charge("gold", 1);
//                value.charge("dust", 3);
//                return Optional.of(value);
//            }
//            Orb value = new Orb(this.getName());
//            value.charge("gold", 1);
//            value.charge("dust", 3);
//            return Optional.of(value);
//        }
//        return Optional.empty();
//    }

    public boolean isBroken() {
        return false;
    }
}