package pollub.rpghelper.quests.rewards;

import pollub.rpghelper.items.base.Item;
import java.util.List;
import java.util.Collections;

// Bridge (Piotr Wróbel)
public class BasicReward implements Reward {
    private int experience;
    private int gold;

    public BasicReward(int experience, int gold) {
        this.experience = experience;
        this.gold = gold;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public boolean isItemReward() {
        return false; // BasicReward does not contain pollub.rpghelper.items
    }

    @Override
    public List<Item> getItems() {
        return Collections.emptyList(); // Return an empty list for BasicReward
    }
}
// Bridge end - week 3

