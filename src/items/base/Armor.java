package items.base;

import items.ItemData;
import strategies.ArmorUsageStrategy;
import strategies.ItemUsageStrategy;

public class Armor implements Item {

    private String name;
    private Double armor;
    private Double health;

    private ItemUsageStrategy usageStrategy;

    public Armor(ItemData data) {
        this.name = data.getName();
        this.armor = data.getArmor();
        this.health = data.getHealth();

        this.usageStrategy = new ArmorUsageStrategy(this);
    }

    // Prototype Pattern Implementation - (Yurii Tyshchenko)
    public Armor(Armor instance) {
        this.name = instance.getName();
        this.armor = instance.getArmor();
        this.health = instance.getHealth();

        this.usageStrategy = new ArmorUsageStrategy(this);
    }

    @Override
    public Item clone() {
        return new Armor(this);
    }
    // Prototype Pattern Implementation end - week 2

    @Override
    public void use() {
        if (usageStrategy != null) {
            usageStrategy.use();
        } else {
            System.out.println("No usage strategy defined for this armor.");
        }
    }

    @Override
    public void setUsageStrategy(ItemUsageStrategy usageStrategy) {

    }

    @Override
    public void display() {
        System.out.println("=======");
        System.out.println("Name: " + this.name);
        System.out.println("ARMOR ITEM");
        System.out.println("-------");
        System.out.println("Armor: " + this.armor);
        System.out.println("Health: " + this.health);
        System.out.println("=======");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArmor() {
        return armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }
}
