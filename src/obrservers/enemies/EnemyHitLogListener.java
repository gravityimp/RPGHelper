package obrservers.enemies;

import enemies.Enemy;
import obrservers.EventListener;

import java.io.File;
import java.util.Date;

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

