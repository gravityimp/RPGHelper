package pollub.rpghelper.items.base;

import pollub.rpghelper.items.ItemData;
import pollub.rpghelper.strategies.ItemUsageStrategy;
import pollub.rpghelper.strategies.WeaponUsageStrategy;

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
        try {
            if(usageStrategy == null)
                throw new Exception("No usage strategy defined for this armor.");

            usageStrategy.use();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setUsageStrategy(ItemUsageStrategy usageStrategy) {
        this.usageStrategy = usageStrategy;
    }

    @Override
    public void display() {
        System.out.println("Weapon name: " + this.name);
        System.out.println("Damage: " + this.damage);
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
