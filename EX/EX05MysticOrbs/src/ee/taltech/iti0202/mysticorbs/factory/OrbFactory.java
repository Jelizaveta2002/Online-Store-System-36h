package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.List;

public class OrbFactory {
    private final ResourceStorage resourceStorage;
    private final ArrayList<Oven> listOfOvens = new ArrayList<>();
    public OrbFactory(ResourceStorage resourceStorage) {
        this.resourceStorage = resourceStorage;
    }

    public void addOven(Oven oven) {
        if (!listOfOvens.isEmpty() && oven.getName() != null && oven.getResourceStorage() != null) {
            for (Oven oneOven : listOfOvens) {
                if (oven.getResourceStorage() == oneOven.getResourceStorage() && oven.getName().equals(oneOven.getName())) {
                    return;
                }
            }
            listOfOvens.add(oven);
        }
        if (oven.getName() != null && oven.getResourceStorage() != null) {
            listOfOvens.add(oven);
        }
    }

    public List<Oven> getOvens() {
        return listOfOvens;
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

    public List<Oven> getOvensThatCannotBeFixed() {
        return null;
    }

    public void getRidOfOvensThatCannotBeFixed() {

    }

    public void optimizeOvensOrder() {

    }
}
