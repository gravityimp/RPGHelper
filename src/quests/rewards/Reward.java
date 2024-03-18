package quests.rewards;

import items.base.Item;
import java.util.List;

// Bridge (Piotr Wróbel)
public interface Reward {
    int getExperience();
    int getGold();
    boolean isItemReward();
    List<Item> getItems();
}
// Bridge end - week 3

