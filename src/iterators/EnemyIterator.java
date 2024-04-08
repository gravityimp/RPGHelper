package iterators;

import enemies.Enemy;

public interface EnemyIterator {
    boolean hasNext();

    Enemy getNext();

    void reset();
}
