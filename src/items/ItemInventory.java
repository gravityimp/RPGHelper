package items;

import items.base.Item;

import java.util.ArrayList;
import java.util.List;

// Composite - Yurii Tyshchenko
public class ItemInventory implements Item {
    private List<Item> items = new ArrayList<>();
    private int size = 1;

    public ItemInventory(int size) {
        if (size < 1) this.size = 1;
        else this.size = size;
    }

    public boolean addItem(Item item) {
        if (items.size() == size) return false;
        items.add(item);
        return true;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    @Override
    public void use() {

    }

    @Override
    public void display() {

    }

    @Override
    public Item clone() {
        return null;
    }
}
