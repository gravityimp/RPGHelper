package iterators;

import enemies.Enemy;
import enemies.HumanEnemy;

import java.util.List;

public class HumanEnemyIterator implements EnemyIterator {
    private List<HumanEnemy> humanEnemies;
    private int currentIndex;

    public HumanEnemyIterator(List<HumanEnemy> humanEnemies) {
        this.humanEnemies = humanEnemies;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < humanEnemies.size();
    }

    @Override
    public Enemy getNext() {
        if (hasNext()) {
            return humanEnemies.get(currentIndex++);
        }
        return null;
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
