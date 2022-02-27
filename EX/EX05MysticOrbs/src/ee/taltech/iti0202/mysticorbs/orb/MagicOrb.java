package ee.taltech.iti0202.mysticorbs.orb;

public class MagicOrb extends Orb{
    private Integer energy = 0;

    public MagicOrb(String creator) {
        super(creator);
    }

    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.trim().isEmpty() && amount != 0) {
            energy += resource.length() * amount * 2;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public String toString() {
        return "Orb by " + super.getCreator();
    }

    public static void main(String[] args) {
        Orb orb = new MagicOrb("CreatorHere");
        orb.charge("magic wind", 2);
        System.out.println(orb.getEnergy());
    }

}
