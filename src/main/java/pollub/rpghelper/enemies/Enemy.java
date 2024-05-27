package pollub.rpghelper.enemies;

import pollub.rpghelper.adapters.Entity;
import pollub.rpghelper.obrservers.enemies.EnemyCreatedLogListener;
import pollub.rpghelper.obrservers.EventManager;
import pollub.rpghelper.obrservers.enemies.EnemyHitLogListener;

import java.io.File;

// Prototype Pattern Declaration - (Piotr Wróbel)
public abstract class Enemy implements Entity {

    public EventManager events;

    private double health;
    private double damage;

    public Enemy(double health, double damage) {
        this.health = health;
        this.damage = damage;

        this.events = new EventManager("created", "hit");
        this.events.subscribe("created", new EnemyCreatedLogListener(this, new File("enemyLog.txt")));
        this.events.subscribe("hit", new EnemyHitLogListener(this, new File("enemyLog.txt")));

        events.notify("created");
    }

    public abstract Enemy clone(); // Prototype Pattern Declaration end - week 2

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void takeDamage(double damage) {
        this.health -= damage;
        events.notify("hit", Double.toString(damage));
    }
}
