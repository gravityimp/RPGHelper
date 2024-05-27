package pollub.rpghelper.enemies;

public class HumanEnemy extends Enemy {

    public HumanEnemy(double health, double damage) {
        super(health, damage);
    }

    // Prototype Pattern Implementation - (Piotr Wróbel)
    public HumanEnemy(HumanEnemy instance) {
        super(instance.getHealth(), instance.getDamage());
    }

    @Override
    public Enemy clone() {
        return new HumanEnemy(this);
    }
    // Prototype Pattern Implementation end - week 2
}
