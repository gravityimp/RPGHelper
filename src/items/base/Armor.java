package items.base;

import items.ItemData;

public class Armor implements Item{

    private String name;
    private Double armor;
    private Double health;

    public Armor(ItemData data) {
        this.name = data.getName();
        this.armor = data.getArmor();
        this.health = data.getHealth();
    }

    // Prototype Pattern Implementation - (Yurii Tyshchenko)
    public Armor(Armor instance) {
        this.name = instance.getName();
        this.armor = instance.getArmor();
        this.health = instance.getHealth();
    }

    @Override
    public Item clone() {
        return new Armor(this);
    }
    // Prototype Pattern Implementation end - week 2

    @Override
    public void use() {
        System.out.println("Equipped armor " + this.name + "!");
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
