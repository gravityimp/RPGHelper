package items.base;

import items.ItemData;

public class Weapon implements Item {
    private String name;
    private Double damage;

    public Weapon(ItemData data) {
        this.name = data.getName();
        this.damage = data.getDamage();
    }

    // Prototype Pattern Implementation - (Yurii Tyshchenko)
    public Weapon(Weapon instance) {
        this.name = instance.name;
        this.damage = instance.damage;
    }

    @Override
    public Item clone() {
        return new Weapon(this);
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
        System.out.println("WEAPON ITEM");
        System.out.println("-------");
        System.out.println("Damage: " + this.damage);
        System.out.println("=======");
    }
}
