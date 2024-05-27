package pollub.rpghelper.enemies;

public class MonsterEnemy extends Enemy {

    public MonsterEnemy(double health, double damage) {
        super(health, damage);
    }

    // Prototype Pattern Implementation - (Piotr Wróbel)
    public MonsterEnemy(MonsterEnemy instance) {
        super(instance.getHealth(), instance.getDamage());
    }

    @Override
    public Enemy clone() {
        return new MonsterEnemy(this);
    }
    // Prototype Pattern Implementation end - week 2
}
