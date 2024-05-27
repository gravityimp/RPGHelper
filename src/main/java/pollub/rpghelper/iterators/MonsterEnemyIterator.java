package pollub.rpghelper.iterators;

import pollub.rpghelper.enemies.Enemy;
import pollub.rpghelper.enemies.MonsterEnemy;

import java.util.List;

// Iterator - Yurii Tyshchenko
public class MonsterEnemyIterator implements EnemyIterator {
    private List<MonsterEnemy> monsterEnemies;
    private int currentIndex;

    public MonsterEnemyIterator(List<MonsterEnemy> monsterEnemies) {
        this.monsterEnemies = monsterEnemies;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < monsterEnemies.size();
    }

    @Override
    public Enemy getNext() {
        if (hasNext()) {
            return monsterEnemies.get(currentIndex++);
        }
        return null;
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
// Iterator end - week 5