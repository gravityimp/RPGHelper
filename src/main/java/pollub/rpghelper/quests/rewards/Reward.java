package pollub.rpghelper.quests.rewards;

import pollub.rpghelper.items.base.Item;
import java.util.List;

// Bridge (Piotr Wróbel)
public interface Reward {
    int getExperience();
    int getGold();
    boolean isItemReward();
    List<Item> getItems();
}
// Bridge end - week 3

