package pollub.rpghelper.observers.enemies;

import pollub.rpghelper.enemies.Enemy;
import pollub.rpghelper.observers.EventListener;

import java.io.File;

public class EnemyHitLogListener implements EventListener {

    private File file;
    private Enemy enemy;

    public EnemyHitLogListener(Enemy enemy, File file) {
        this.enemy = enemy;
        this.file = file;
    }

    @Override
    public void update(String eventType, String... args) {
        if (args.length >= 1) {
            String damage = args[0];
            System.out.println(enemy.toString() + " was hit by " + damage + "! File: " + file.getName());
        }
    }
}

