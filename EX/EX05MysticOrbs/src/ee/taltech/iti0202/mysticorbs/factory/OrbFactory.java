package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.List;

public class OrbFactory {
    private final ResourceStorage resourceStorage;
    public OrbFactory(ResourceStorage resourceStorage) {
        this.resourceStorage = resourceStorage;
    }

    public void addOven(Oven oven) {

    }

    public List<Oven> getOvens() {
        return null;
    }

    public List<Orb> getAndClearProducedOrbsList() {
        return null;
    }

    public int produceOrbs() {
        return 0;
    }

    public int produceOrbs(int cycles) {
        return 0;
    }
}
