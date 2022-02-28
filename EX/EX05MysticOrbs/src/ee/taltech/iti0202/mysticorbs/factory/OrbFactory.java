package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.List;

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
        return listOfOrbs;
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
        resourceStorage.addResource("wood", 33);
        resourceStorage.addResource("wood", 34);
        OrbFactory factory = new OrbFactory(resourceStorage);
        Oven oven = new Oven("oven1", resourceStorage);
        Oven oven2 = new Oven("oven1", resourceStorage);
        Oven oven3 = new Oven("oven2", resourceStorage);
        Oven oven4 = new Oven("oven3", resourceStorage);
        factory.addOven(oven);
        factory.addOven(oven2);
        factory.addOven(oven3);
        factory.addOven(oven4);
        System.out.println(factory.getOvens());
    }
}
