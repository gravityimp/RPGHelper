package enemies;

import adapters.Entity;

// Prototype Pattern Declaration - (Piotr Wróbel)
public abstract class Enemy implements Entity {

    private double health;
    private double damage;

    public Enemy(double health, double damage) {
        this.health = health;
        this.damage = damage;
    }

    public abstract Enemy clone(); // Prototype Pattern Declaration end - week 2

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }
}
