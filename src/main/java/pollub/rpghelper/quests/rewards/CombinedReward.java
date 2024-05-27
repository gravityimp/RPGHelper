package pollub.rpghelper.quests.rewards;

import pollub.rpghelper.items.base.Item;
import java.util.List;

// Bridge, Composite (Piotr Wróbel)
public class CombinedReward implements Reward {
    private BasicReward basicReward;
    private ItemReward itemReward;

    public CombinedReward(int experience, int gold, List<Item> items) {
        this.basicReward = new BasicReward(experience, gold);
        this.itemReward = new ItemReward(items);
    }

    @Override
    public int getExperience() {
        return basicReward.getExperience();
    }

    @Override
    public int getGold() {
        return basicReward.getGold();
    }

    @Override
    public boolean isItemReward() {
        return itemReward.isItemReward();
    }

    @Override
    public List<Item> getItems() {
        return itemReward.getItems();
    }
}

// Bridge, Composite end - week 3