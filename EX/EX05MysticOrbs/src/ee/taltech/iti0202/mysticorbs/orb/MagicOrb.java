package ee.taltech.iti0202.mysticorbs.orb;

import java.util.HashMap;

public class MagicOrb {
    private final String creator;
    private Integer energy = 1;
    private HashMap<String, Integer> mapOfOrbs = new HashMap<String, Integer>();

    public MagicOrb(String creator) {
        this.creator = creator;
    }
    public void charge(String resource, int amount) {

    }

    public String toString() {
        return null;
    }
}
