package pollub.rpghelper.enemies;

// Proxy Pattern - Yurii Tyshchenko
public class EnemyProxyImpl implements EnemyProxy {
    private Enemy enemy;

    public EnemyProxyImpl(double health, double damage, Class<? extends Enemy> enemyClass) {
        try {
            this.enemy = enemyClass.getDeclaredConstructor(double.class, double.class).newInstance(health, damage);
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    @Override
    public double getHealth() {
        return enemy.getHealth();
    }

    @Override
    public double getDamage() {
        return enemy.getDamage();
    }
}
// Proxy Pattern end - week 4