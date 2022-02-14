package ee.taltech.iti0202.lotr;

public class Person {

    String race;
    String name;
    Ring ring;

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
        if (this.ring == null) {
            this.ring = ring;
        }
    }

    public String isSauron() {
        if (this.name.equals("Sauron") && this.ring.material.equals(Ring.Material.GOLD) && this.ring.type.equals(Ring.Type.THE_ONE)) {
            return "Affirmative";
        }
        else if (this.name.equals("Sauron") && !this.ring.material.equals(Ring.Material.GOLD) && this.ring.type.equals(Ring.Type.THE_ONE)) {
            return "No, the ring is fake!";
        }
        else if (!this.name.equals("Sauron") && !this.ring.material.equals(Ring.Material.GOLD) && this.ring.type.equals(Ring.Type.THE_ONE)) {
            return "No, he just stole the ring";
        }
        else if (this.name.equals("Sauron") && (!this.ring.getType().equals(Ring.Type.THE_ONE) || this.ring == null)) {
            return "No, but he's claiming to be";
        }
        else {
            return "No";
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
