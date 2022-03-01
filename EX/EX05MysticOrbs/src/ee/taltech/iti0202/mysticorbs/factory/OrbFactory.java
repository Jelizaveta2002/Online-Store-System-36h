package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrbFactory {
    private final ResourceStorage resourceStorage;
    private final ArrayList<Oven> listOfOvens = new ArrayList<>();
    private final ArrayList<Orb> listOfOrbs = new ArrayList<>();

    /**
     * Create a resourceStorage.
     */
    public OrbFactory(ResourceStorage resourceStorage) {
        this.resourceStorage = resourceStorage;
    }


    /**
     * Create a resourceStorage.
     */
    public void addOven(Oven oven) {
        if (!listOfOvens.isEmpty() && oven.getName() != null && oven.getResourceStorage() != null) {
            for (Oven oneOven : listOfOvens) {
                if (oven.getResourceStorage() == oneOven.getResourceStorage()
                        && oven.getName().equals(oneOven.getName())) {
                    return;
                }
            }
            listOfOvens.add(oven);
            return;
        }
        if (oven.getName() != null && oven.getResourceStorage() != null) {
            listOfOvens.add(oven);
        }
    }

    /**
     * Create a resourceStorage.
     */
    public List<Oven> getOvens() {
        return listOfOvens;
    }

    /**
     * Create a resourceStorage.
     */
    public List<Orb> getAndClearProducedOrbsList() {
        ArrayList<Orb> listToReturn = new ArrayList<Orb>(this.listOfOrbs);
        this.listOfOrbs.clear();
        System.out.println(listOfOrbs);
        return listToReturn;
    }

    /**
     * Create a resourceStorage.
     */
    public int produceOrbs() {
        int counter = 0;
        for (Oven oven : listOfOvens) {
            Optional<Orb> optionalOrb = oven.craftOrb();
            if (optionalOrb.isPresent()) {
                counter += 1;
                listOfOrbs.add(optionalOrb.get());
                System.out.println(listOfOrbs);
            }
        }
        return counter;
    }

    /**
     * Create a resourceStorage.
     */
    public int produceOrbs(int cycles) {
        int counter = 0;
        for (int i = 0; i < cycles; i++) {
            counter += produceOrbs();
        }
        return counter;
    }


    /**
     * Create a resourceStorage.
     */
    public List<Oven> getOvensThatCannotBeFixed() {
        return null;
    }

    /**
     * Create a resourceStorage.
     */
    public void getRidOfOvensThatCannotBeFixed() {

    }

    /**
     * Create a resourceStorage.
     */
    public void optimizeOvensOrder() {
    }
}
