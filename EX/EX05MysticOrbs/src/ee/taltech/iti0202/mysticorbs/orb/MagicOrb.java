package ee.taltech.iti0202.mysticorbs.orb;

public class MagicOrb extends Orb{
    private Integer energy = 0;
    private boolean absorbed = false;
    private boolean isSpaceOrb = false;

    public MagicOrb(String creator) {
        super(creator);
    }

    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.trim().isEmpty() && amount > 0) {
            energy += resource.length() * amount * 2;
        }
    }

    public boolean returnIsSpace() {
        return this.isSpaceOrb;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public String toString() {
        return "MagicOrb by " + super.getCreator();
    }



    public boolean returnState() {
        return this.absorbed;
    }

    public void changeState() {
        this.absorbed = true;
        this.energy = 0;
    }

    public static void main(String[] args) {
        Orb orb = new MagicOrb("CreatorHere");
        orb.charge("magic wind", 2);
        System.out.println(orb.getEnergy());
    }

}