package items.base;

import items.ItemData;
import strategies.ItemUsageStrategy;
import strategies.WeaponUsageStrategy;

public class Weapon implements Item {
    private String name;
    private Double damage;

    private ItemUsageStrategy usageStrategy;

    public Weapon(ItemData data) {
        this.name = data.getName();
        this.damage = data.getDamage();

        this.usageStrategy = new WeaponUsageStrategy(this);
    }

    // Prototype Pattern Implementation - (Yurii Tyshchenko)
    public Weapon(Weapon instance) {
        this.name = instance.name;
        this.damage = instance.damage;

        this.usageStrategy = new WeaponUsageStrategy(this);
    }

    @Override
    public Item clone() {
        return new Weapon(this);
    }
    // Prototype Pattern Implementation end - week 2

    @Override
    public void use() {
        if (usageStrategy != null) {
            usageStrategy.use();
        } else {
            System.out.println("No usage strategy defined for this weapon.");
        }
    }

    @Override
    public void setUsageStrategy(ItemUsageStrategy usageStrategy) {

    }

    @Override
    public void display() {
        System.out.println("=======");
        System.out.println("Name: " + this.name);
        System.out.println("WEAPON ITEM");
        System.out.println("-------");
        System.out.println("Damage: " + this.damage);
        System.out.println("=======");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDamage() {
        return damage;
    }
}
