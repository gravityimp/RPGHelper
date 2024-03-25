package items;

import items.base.Item;

import java.util.ArrayList;
import java.util.List;

// Composite - Yurii Tyshchenko
public class ItemInventory implements Item {
    private List<Item> items = new ArrayList<>();
    private final int max_size;

    public ItemInventory(int maxSize) {
        max_size = maxSize;
    }

    @Override
    public void use() {
        for(Item item: items) {
            item.use();
        }
    }

    @Override
    public void display() {
        for(Item item: items) {
            item.display();
        }
    }

    @Override
    public Item clone() { return null; }

    public void add(Item item) {
        if (items.size() < max_size) {
            items.add(item);
        }
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public void clear() {
        items.clear();
    }
}
