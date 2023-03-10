package ee.taltech.iti0202.lotr;




public class Ring {
    public enum Type {
        THE_ONE, GOLDEN, NENYA, OTHER
    }

    public enum Material {
        GOLD, SILVER, BRONZE, PLASTIC, DIAMOND
    }
    private Type type;
    private Material material;
    public Ring(Type type, Material material) {
        this.type = type;
        this.material = material;
    }

    public Type getType() {
        return type;
    }

    public Material getMaterial() {
        return material;
    }
}

