package ee.taltech.iti0202.lotr;




public class Ring {
    private enum Type {
        THE_ONE, GOLDEN, NENYA, OTHER
    }

    private enum Material {
        GOLD, SILVER, BRONZE, PLASTIC, DIAMOND
    }
    Type type;
    Material material;
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

