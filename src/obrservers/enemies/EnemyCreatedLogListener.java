package obrservers.enemies;

import enemies.Enemy;
import obrservers.EventListener;

import java.io.File;
import java.util.Date;

public class EnemyCreatedLogListener implements EventListener {

    private File file;
    private Enemy enemy;

    public EnemyCreatedLogListener(Enemy enemy, File file) {
        this.enemy = enemy;
        this.file = file;
    }

    @Override
    public void update(String eventType, String... args) {
        System.out.println("Created " + enemy.toString() + " on " + (new Date()).toString() + " ! File: " + file.getName());
    }
}
