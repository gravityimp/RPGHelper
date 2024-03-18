package items;

import items.base.Armor;
import items.base.Item;
import items.base.Weapon;

// Simple Factory - Yurii Tyshchenko
class ItemFactory {

    private ItemFactory() {}

    // Method to create different types of items based on input
    public static Item createItem(ItemType type, ItemData data) {
        return switch (type) {
            case ItemType.WEAPON -> new Weapon(data);
            case ItemType.ARMOR -> new Armor(data);
            default -> throw new IllegalArgumentException("Invalid item type: " + type);
        };
    }
}
// Simple Factory end - week 2