package quests.rewards;

import items.base.Item;
import java.util.List;
import java.util.ArrayList;

// Bridge (Piotr Wróbel)
public class ItemReward implements Reward {
    private List<Item> items;

    public ItemReward() {
        this.items = new ArrayList<>();
    }

    public ItemReward(List<Item> items) {
        this.items = items;
    }

    @Override
    public int getExperience() { return 0; }

    @Override
    public int getGold() { return 0; }

    @Override
    public boolean isItemReward() {
        return true;
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
// Bridge end - week 3