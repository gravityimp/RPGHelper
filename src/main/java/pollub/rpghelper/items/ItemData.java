package pollub.rpghelper.items;

// Builder Pattern - (Yurii Tyshchenko)
public class ItemData {

    private String name;
    private double damage;
    private double health;
    private double armor;

    private ItemData() {}

    public ItemData(ItemDataBuilder builder) {
        this.name = builder.name;
        this.damage = builder.damage;
        this.health = builder.health;
        this.armor = builder.armor;
    }

    public static class ItemDataBuilder {
        private String name;
        private double damage;
        private double health;
        private double armor;

        public ItemDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ItemDataBuilder damage(double damage) {
            this.damage = damage;
            return this;
        }

        public ItemDataBuilder health(double health) {
            this.health = health;
            return this;
        }

        public ItemDataBuilder armor(double armor) {
            this.armor = armor;
            return this;
        }

        public ItemData build() {
            return new ItemData(this);
        }
    }

    public String getName() { return name; }

    public double getDamage() {
        return damage;
    }

    public double getHealth() {
        return health;
    }

    public double getArmor() {
        return armor;
    }
}
// Builder Pattern end - week 2
