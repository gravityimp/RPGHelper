package items;

import items.base.Item;

// Facade Pattern - Yurii Tyshchenko
public class ItemFacade {

    public static Item createWeapon(ItemData data) {
        return ItemFactory.createItem(ItemType.WEAPON, data);
    }

    public static Item createArmor(ItemData data) {
        return ItemFactory.createItem(ItemType.ARMOR, data);
    }
}
// Facade Pattern end - week 4
