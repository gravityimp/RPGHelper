package decorators;

import items.base.Item;

// Decorator Pattern - Yurii Tyshchenko
public class EnchantedItemDecorator implements Item {
    private Item item;
    private String enchantment;

    public EnchantedItemDecorator(Item item, String enchantment) {
        this.item = item;
        this.enchantment = enchantment;
    }

    @Override
    public void use() {
        item.use();
        System.out.println("Applying enchantment: " + enchantment);
    }

    @Override
    public void display() {
        item.display();
        System.out.println("Enchantment: " + enchantment);
    }

    @Override
    public Item clone() {
        Item clonedItem = item.clone();
        return new EnchantedItemDecorator(clonedItem, enchantment);
    }
}
// Decorator Pattern end - week 3
