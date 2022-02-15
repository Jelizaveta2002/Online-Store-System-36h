package ee.taltech.iti0202.lotr;

public class Person {

    private String race;
    private String name;
    private Ring ring;

    public Person(String race, String name, Ring ring) {
        this.race = race;
        this.name = name;
        this.ring = ring;
    }

    public Person(String race, String name) {
        this.race = race;
        this.name = name;
        this.ring = null;
    }

    public void setRing(Ring ring) {
        this.ring = ring;
    }

    public String isSauron() {
        if (this.ring != null) {
            if (this.getName().equals("Sauron") && this.ring.getMaterial().equals(Ring.Material.GOLD) && this.ring.getType().equals(Ring.Type.THE_ONE)) {
                return "Affirmative";
            }
            else if (this.getName().equals("Sauron") && !this.ring.getMaterial().equals(Ring.Material.GOLD) && this.ring.getType().equals(Ring.Type.THE_ONE)) {
                return "No, the ring is fake!";
            }
            else if (!this.getName().equals("Sauron") && this.ring.getMaterial().equals(Ring.Material.GOLD) && this.ring.getType().equals(Ring.Type.THE_ONE)) {
                return "No, he just stole the ring";
            }
            else if (this.getName().equals("Sauron") && !this.ring.getType().equals(Ring.Type.THE_ONE)) {
                return "No, but he's claiming to be";
            }
            else {
                return "No";
            }
        }
        else {
            if (this.getName().equals("Sauron")) {
                return "No, but he's claiming to be";
            }
            else {
                return "No";
            }
        }
    }

    public String getRace() {
        return race;
    }

    public String getName() {
        return name;
    }

    public Ring getRing() {
        return ring;
    }
}
