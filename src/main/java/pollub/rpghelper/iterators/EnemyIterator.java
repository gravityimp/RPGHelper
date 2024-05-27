package pollub.rpghelper.iterators;

import pollub.rpghelper.enemies.Enemy;

// Iterator - Yurii Tyshchenko
public interface EnemyIterator {
    boolean hasNext();

    Enemy getNext();

    void reset();
}
// Iterator end - week 5