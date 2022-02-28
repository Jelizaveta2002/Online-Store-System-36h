package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.MagicOven;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.oven.SpaceOven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrbFactory {
    private final ResourceStorage resourceStorage;
    private final ArrayList<Oven> listOfOvens = new ArrayList<>();
    private final ArrayList<Orb> listOfOrbs = new ArrayList<>();
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
            return;
        }
        if (oven.getName() != null && oven.getResourceStorage() != null) {
            listOfOvens.add(oven);
        }
    }

    public List<Oven> getOvens() {
        return listOfOvens;
    }

    public List<Orb> getAndClearProducedOrbsList() {
        ArrayList<Orb> listToReturn = new ArrayList<Orb>(this.listOfOrbs);
        this.listOfOrbs.clear();
        return listToReturn;
    }

    public int produceOrbs() {
        int counter = 0;
        for (Oven oven : listOfOvens) {
            if (oven.craftOrb().isPresent()) {
                counter += 1;
                listOfOrbs.add(oven.craftOrb().get());
            }
        }
        return counter;
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

    public static void main(String[] args) {
        ResourceStorage resourceStorage = new ResourceStorage();
        resourceStorage.addResource("pearl", 999999);
        resourceStorage.addResource("silver", 999999);
        resourceStorage.addResource("gold", 999999);
        resourceStorage.addResource("dust", 999999);
        resourceStorage.addResource("meteorite stone", 999999);
        resourceStorage.addResource("star fragment", 999999);

        OrbFactory orbFactory = new OrbFactory(resourceStorage);

        Oven oven1 = new Oven("Oven1", resourceStorage);

        Oven oven2 = new SpaceOven("SpaceOven1", resourceStorage);
        Oven oven3 = new MagicOven("MagicOven1", resourceStorage);
        orbFactory.addOven(oven1);
        orbFactory.addOven(oven2);
        orbFactory.addOven(oven3);
        orbFactory.produceOrbs();
        System.out.println(orbFactory.getAndClearProducedOrbsList());
    }
}
