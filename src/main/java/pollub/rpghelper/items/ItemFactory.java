package pollub.rpghelper.items;

import pollub.rpghelper.items.base.Armor;
import pollub.rpghelper.items.base.Item;
import pollub.rpghelper.items.base.Weapon;

// Simple Factory - Yurii Tyshchenko
class ItemFactory {

    private ItemFactory() {}

    // Method to create different types of pollub.rpghelper.items based on input
    public static Item createItem(ItemType type, ItemData data) {
        return switch (type) {
            case ItemType.WEAPON -> new Weapon(data);
            case ItemType.ARMOR -> new Armor(data);
            default -> throw new IllegalArgumentException("Invalid item type: " + type);
        };
    }
}
// Simple Factory end - week 2